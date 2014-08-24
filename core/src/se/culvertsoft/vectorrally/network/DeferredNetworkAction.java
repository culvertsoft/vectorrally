package se.culvertsoft.vectorrally.network;

public interface DeferredNetworkAction {
	void applyTo(NetworkInterface tgt);
}
