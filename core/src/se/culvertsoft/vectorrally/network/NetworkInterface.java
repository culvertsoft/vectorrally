package se.culvertsoft.vectorrally.network;

import java.util.concurrent.ConcurrentLinkedQueue;

import se.culvertsoft.mgen.javapack.classes.MGenBase;
import se.culvertsoft.mnet.api.Route;
import se.culvertsoft.vectorrally.model.Dispatcher;
import se.culvertsoft.vectorrally.model.Handler;

public abstract class NetworkInterface extends Handler {

	private final Server2MNetBridge m_mnet;
	private final ConcurrentLinkedQueue<DeferredNetworkAction> m_queuedNetworkActions;
	private boolean m_flushUnderWay = false;
	private Route m_currentRoute = null; // The route we're currently processing
											// a
											// message from

	/********************************************************
	 * 
	 * 
	 * Public api
	 * 
	 *******************************************************/

	public NetworkInterface() {
		m_mnet = new Server2MNetBridge(this);
		m_queuedNetworkActions = new ConcurrentLinkedQueue<>();
	}

	public void flushActions() {

		// Don't act on recursion...
		if (m_flushUnderWay)
			return;

		try {
			m_flushUnderWay = true;
			while (!m_queuedNetworkActions.isEmpty())
				m_queuedNetworkActions.poll().applyTo(this);
		} finally {
			m_flushUnderWay = false;
		}

	}

	public NetworkInterface send(MGenBase msg, boolean bnry) {
		return send(msg, bnry, (Route) null);
	}

	public NetworkInterface send(MGenBase msg) {
		return send(msg, false);
	}

	public NetworkInterface broadcast(MGenBase msg, boolean bnry) {
		return send(msg, bnry);
	}

	public NetworkInterface broadcast(MGenBase msg) {
		return broadcast(msg, false);
	}

	/********************************************************
	 * 
	 * 
	 * Hidden api
	 * 
	 *******************************************************/

	void queueAction(DeferredNetworkAction action) {
		m_queuedNetworkActions.add(action);
	}

	final void handleMessage(MGenBase msg, Route route) {
		m_currentRoute = route;
		Dispatcher.dispatch(msg, this);
	}

	NetworkInterface start() {
		m_mnet.start();
		return this;
	}

	NetworkInterface stop() {
		m_mnet.stop();
		return this;
	}

	NetworkInterface send(MGenBase msg, boolean bnry, final Route route) {
		m_mnet.send(msg, bnry, route);
		return this;
	}

	NetworkInterface reply(MGenBase msg, boolean bnry) {
		return send(msg, bnry, currentRoute());
	}

	NetworkInterface reply(MGenBase msg) {
		return reply(msg, false);
	}

	Route currentRoute() {
		return m_currentRoute;
	}

	/********************************************************
	 * 
	 * 
	 * Callbacks
	 * 
	 *******************************************************/

	abstract void handleConnect(Route route);

	abstract void handleDisconnect(Route route, String reason);

	abstract void handleError(Exception error, Object source);

}
