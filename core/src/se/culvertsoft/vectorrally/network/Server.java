package se.culvertsoft.vectorrally.network;

import static se.culvertsoft.vectorrally.utils.Utils.contains;
import static se.culvertsoft.vectorrally.utils.Utils.filter;
import static se.culvertsoft.vectorrally.utils.Utils.head;
import static se.culvertsoft.vectorrally.utils.W.£;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

import se.culvertsoft.mgen.javapack.classes.MGenBase;
import se.culvertsoft.mnet.api.Route;
import se.culvertsoft.vectorrally.model.entity.CarColor;
import se.culvertsoft.vectorrally.model.network.ChatMessage;
import se.culvertsoft.vectorrally.model.network.Player;
import se.culvertsoft.vectorrally.model.network.PlayerCheckinReply;
import se.culvertsoft.vectorrally.model.network.PlayerCheckinRequest;
import se.culvertsoft.vectorrally.model.network.PlayerJoinedMessage;
import se.culvertsoft.vectorrally.model.network.PlayerLeftMessage;
import se.culvertsoft.vectorrally.model.network.PlayerList;
import se.culvertsoft.vectorrally.model.wish.Wish;

public class Server extends NetworkInterface {

	/********************************************************
	 * 
	 * 
	 * MEMBERS
	 * 
	 *******************************************************/

	private final HashMap<Route, Player> m_players;

	/********************************************************
	 * 
	 * 
	 * PUBLIC API
	 * 
	 *******************************************************/

	public Server() {
		m_players = new HashMap<>();
	}

	public Server start() {
		super.start();
		return this;
	}

	public Server stop() {
		super.stop();
		return this;
	}

	public Collection<Player> players() {
		flushActions();
		return m_players.values();
	}

	public Server send(MGenBase msg, boolean bnry, Player player) {
		flushActions();
		if (player != null) {
			getRouteTo(player).ifPresent(r -> send(msg, bnry, r));
		} else {
			send(msg, bnry, (Route) null);
		}

		return this;
	}

	/********************************************************
	 * 
	 * 
	 * Message handlers
	 * 
	 *******************************************************/

	@Override
	protected void handle(Wish o) {
		// TODO: Add to current wishlist,
		// TODO: When step is called, push current wishlist to clients
	}

	@Override
	protected void handle(ChatMessage o) {
		broadcast(o);
	}

	@Override
	protected void handle(PlayerCheckinRequest o) {

		final boolean isNewPlayer = m_players.remove(currentRoute()) == null;

		final Optional<CarColor> freeCarColor = firstFreeCarColor();
		if (!freeCarColor.isPresent()) {
			reply(new PlayerCheckinReply().setResult(false).setFailReason(
					"Server Full"));
			return;
		}

		Player player = o.hasPlayer() ? o.getPlayer() : new Player();

		if (!player.hasName()) {
			player.setName(UUID.randomUUID().toString());
		}

		if (!player.hasCarColor() || !isColorAvailable(player.getCarColor())) {
			player.setCarColor(freeCarColor.get());
		}

		m_players.put(currentRoute(), player);

		reply(new PlayerCheckinReply().setPlayer(player).setResult(true));

		if (isNewPlayer) {
			broadcast(new PlayerJoinedMessage(player));
		}

		broadcastUpdatedPlayerList();

	}

	/********************************************************
	 * 
	 * 
	 * Network action handlers
	 * 
	 *******************************************************/

	@Override
	void handleConnect(Route route) {
		System.out
				.println("Route "
						+ route
						+ " connected. Waiting for him to check in before doing anything...");
	}

	@Override
	void handleDisconnect(Route route, String reason) {
		Player player = m_players.remove(route);
		if (player != null) {
			broadcast(new PlayerLeftMessage(player));
		}
	}

	@Override
	void handleError(Exception error, Object source) {
		System.out.println("Server error " + error + " from " + source);
	}

	/********************************************************
	 * 
	 * 
	 * Helpers
	 * 
	 *******************************************************/

	private Optional<Route> getRouteTo(Player p) {
		return £(m_players.entrySet()).find(
				e -> e.getValue().getCarColor() == p.getCarColor()).map(
				x -> x.getKey());
	}

	private void broadcastUpdatedPlayerList() {
		broadcast(new PlayerList().setPlayers(new ArrayList<Player>(players())));
	}

	private boolean isColorAvailable(CarColor carColor) {
		return !£(players()).contains(p -> p.getCarColor() == carColor);
	}

	private Optional<CarColor> firstFreeCarColor() {
		return £(CarColor.values()).filter(x -> isColorAvailable(x)).headOption();
	}

}
