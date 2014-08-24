package se.culvertsoft.vectorrally.network;

import java.io.IOException;

import se.culvertsoft.mgen.javapack.classes.MGenBase;
import se.culvertsoft.mnet.DataMessage;
import se.culvertsoft.mnet.Message;
import se.culvertsoft.mnet.NodeSettings;
import se.culvertsoft.mnet.api.Connection;
import se.culvertsoft.mnet.api.Route;
import se.culvertsoft.mnet.backend.WebsockBackendSettings;
import se.culvertsoft.mnet.client.MNetClient;

public class Server2MNetBridge extends MNetClient {

	private final NetworkInterface m_networkInterface;

	Server2MNetBridge(NetworkInterface networkInterface) {
		super(new WebsockBackendSettings(), new NodeSettings());
		m_networkInterface = networkInterface;
	}

	public void send(MGenBase msg, boolean binary, Route target) {
		try {
			if (binary) {
				send(Serializer.wrtBin(msg), target.endpointId());
			} else {
				send(Serializer.wrtJson(msg), target.endpointId());
			}
		} catch (IOException e) {
			// Shouldnt happen, serializer bug
			e.printStackTrace();
		}
	}

	@Override
	public void handleConnect(Route route) {
		m_networkInterface.queueAction(server -> server.handleConnect(route));
	}

	@Override
	public void handleDisconnect(Route route, String reason) {
		m_networkInterface.queueAction(server -> server.handleDisconnect(route,
				reason));
	}

	@Override
	public void handleError(Exception error, Object source) {
		m_networkInterface.queueAction(server -> server.handleError(error,
				source));
	}

	@Override
	public void handleMessage(Message message, Connection c, Route route) {
		if (message instanceof DataMessage && route != null) {
			try {
				final DataMessage dm = (DataMessage) message;
				final MGenBase msg;
				if (dm.hasBinaryData()) {
					msg = Serializer.read(dm.getBinaryData());
				} else {
					msg = Serializer.read(dm.getStringData());
				}
				m_networkInterface.queueAction(server -> server.handleMessage(
						msg, route));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
