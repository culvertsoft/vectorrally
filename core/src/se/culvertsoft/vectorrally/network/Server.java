package se.culvertsoft.vectorrally.network;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

import se.culvertsoft.mgen.javapack.classes.MGenBase;
import se.culvertsoft.mnet.api.Route;
import se.culvertsoft.vectorrally.model.Dispatcher;
import se.culvertsoft.vectorrally.model.Handler;
import se.culvertsoft.vectorrally.model.entity.CarColor;
import se.culvertsoft.vectorrally.model.network.ChatMessage;
import se.culvertsoft.vectorrally.model.network.Player;
import se.culvertsoft.vectorrally.model.network.PlayerCheckinReply;
import se.culvertsoft.vectorrally.model.network.PlayerCheckinRequest;
import se.culvertsoft.vectorrally.model.network.PlayerJoinedMessage;
import se.culvertsoft.vectorrally.model.network.PlayerLeftMessage;
import se.culvertsoft.vectorrally.model.network.PlayerList;
import se.culvertsoft.vectorrally.model.wish.Wish;

public class Server extends Handler {

	/********************************************************
	 * 
	 * 
	 * MEMBERS
	 * 
	 *******************************************************/

	private final ConcurrentLinkedQueue<Visitor<Server>> m_queuedNetworkActions;
	private final Server2MNetBridge m_mnet;
	private final HashMap<Route, Player> m_players;
	private Route currentRoute = null; // The route we're currently processing a
										// message from

	/********************************************************
	 * 
	 * 
	 * PUBLIC API
	 * 
	 *******************************************************/

	public Server() {
		m_queuedNetworkActions = new ConcurrentLinkedQueue<>();
		m_mnet = new Server2MNetBridge(m_queuedNetworkActions);
		m_players = new HashMap<>();
	}

	public Server start() {
		flushActions();
		m_mnet.start();
		return this;
	}

	public Server stop() {
		flushActions();
		m_mnet.stop();
		return this;
	}

	public Collection<Player> players() {
		flushActions();
		return m_players.values();
	}

	public Server send(MGenBase msg, boolean bnry, Player tg) {
		flushActions();
		if (tg != null) {
			m_players
					.entrySet()
					.stream()
					.filter(x -> x.getValue().getCarColor()
							.equals(tg.getCarColor())).findFirst()
					.ifPresent(x -> send(msg, bnry, x.getKey()));
		} else {
			send(msg, bnry, (Route) null);
		}

		return this;
	}

	public Server send(MGenBase msg, boolean bnry) {
		return send(msg, bnry, (Player) null);
	}

	public Server send(MGenBase msg) {
		return send(msg, false);
	}

	public Server broadcast(MGenBase msg, boolean bnry) {
		return send(msg, bnry);
	}

	public Server broadcast(MGenBase msg) {
		return broadcast(msg, false);
	}

	public Server flushActions() {
		for (Visitor<Server> action : m_queuedNetworkActions)
			action.accept(this);
		return this;
	}

	/********************************************************
	 * 
	 * 
	 * PRIVATE IMPL. Message handlers
	 * 
	 *******************************************************/

	protected void handle(Wish o) {
		// TODO: Add to current wishlist,
		// TODO: When step is called, push current wishlist to clients
	}

	protected void handle(ChatMessage o) {
		broadcast(o);
	}

	protected void handle(PlayerCheckinRequest o) {

		final boolean isNewPlayer = m_players.remove(currentRoute) == null;

		final CarColor firstFreeCarColor = firstFreeCarColor();
		if (firstFreeCarColor == null) {
			reply(new PlayerCheckinReply().setResult(false).setFailReason(
					"Server Full"));
			return;
		}

		Player player = o.hasPlayer() ? o.getPlayer() : new Player();
		
		if (!player.hasName()) {
			player.setName(UUID.randomUUID().toString());
		}

		if (!player.hasCarColor() || !isColorAvailable(player.getCarColor())) {
			player.setCarColor(firstFreeCarColor);
		}

		m_players.put(currentRoute, player);

		reply(new PlayerCheckinReply().setPlayer(player).setResult(true));
		
		if (isNewPlayer) {
			broadcast(new PlayerJoinedMessage(player));
		}
		
		broadcastUpdatedPlayerList();

	}

	private void broadcastUpdatedPlayerList() {
		broadcast(new PlayerList().setPlayers(new ArrayList<Player>(players())));
	}

	private boolean isColorAvailable(CarColor carColor) {
		for (final Player p : players()) {
			if (p.getCarColor().equals(carColor)) {
				return false;
			}
		}
		return true;
	}

	private CarColor firstFreeCarColor() {
		for (final CarColor color : CarColor.values()) {
			if (isColorAvailable(color)) {
				return color;
			}
		}
		return null;
	}

	/********************************************************
	 * 
	 * 
	 * PRIVATE IMPL. Executed on flushActions
	 * 
	 *******************************************************/

	private Server send(MGenBase msg, boolean bnry, final Route route) {
		m_mnet.send(msg, bnry, route);
		return this;
	}

	private Server reply(MGenBase msg, boolean bnry) {
		return send(msg, bnry, currentRoute);
	}

	private Server reply(MGenBase msg) {
		return reply(msg, false);
	}

	void handleConnect(Route route) {
		System.out
				.println("Route "
						+ route
						+ " connected. Waiting for him to check in before doing anything...");
	}

	void handleDisconnect(Route route, String reason) {
		Player player = m_players.remove(route);
		if (player != null) {
			broadcast(new PlayerLeftMessage(player));
		}
	}

	void handleMessage(MGenBase msg, Route route) {
		currentRoute = route;
		Dispatcher.dispatch(msg, this);
	}

	void handleError(Exception error, Object source) {
		System.out.println("Server error " + error + " from " + source);
	}

}
