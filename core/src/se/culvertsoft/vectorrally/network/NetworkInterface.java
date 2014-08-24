package se.culvertsoft.vectorrally.network;

import java.util.concurrent.ConcurrentLinkedQueue;

import se.culvertsoft.mgen.javapack.classes.MGenBase;
import se.culvertsoft.mnet.api.Route;
import se.culvertsoft.vectorrally.model.Dispatcher;
import se.culvertsoft.vectorrally.model.Handler;

public abstract class NetworkInterface extends Handler {

	private final ConcurrentLinkedQueue<DeferredNetworkAction> m_queuedNetworkActions;
	private Route m_currentRoute = null; // The route we're currently processing
											// a
											// message from

	public NetworkInterface() {
		m_queuedNetworkActions = new ConcurrentLinkedQueue<>();
	}

	public void flushActions() {
		while (!m_queuedNetworkActions.isEmpty()) {
			m_queuedNetworkActions.poll().applyTo(this);
		}
	}

	void queueAction(DeferredNetworkAction action) {
		m_queuedNetworkActions.add(action);
	}

	final void handleMessage(MGenBase msg, Route route) {
		m_currentRoute = route;
		Dispatcher.dispatch(msg, this);
	}

	Route currentRoute() {
		return m_currentRoute;
	}

	abstract void handleConnect(Route route);

	abstract void handleDisconnect(Route route, String reason);

	abstract void handleError(Exception error, Object source);

}
