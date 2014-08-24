package se.culvertsoft.vectorrally.network;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import se.culvertsoft.mgen.javapack.classes.MGenBase;
import se.culvertsoft.mnet.Message;
import se.culvertsoft.mnet.api.Connection;

public class LocalPlayerConnection implements Connection {

	private final ConcurrentLinkedQueue<MGenBase> m_messages = new ConcurrentLinkedQueue<>();

	@Override
	public boolean hasBufferedData() {
		return false;
	}

	@Override
	public boolean isConnected() {
		return true;
	}

	@Override
	public void send(Message msg) {
		m_messages.add(msg);
	}

	/**
	 * Pops all received messages from this connection
	 * 
	 * @return all received messages so far
	 */
	public List<MGenBase> pop() {
		final List<MGenBase> out = new ArrayList<>();
		while (!m_messages.isEmpty())
			out.add(m_messages.poll());
		return out;
	}

}
