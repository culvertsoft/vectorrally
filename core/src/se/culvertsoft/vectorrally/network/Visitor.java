package se.culvertsoft.vectorrally.network;

public interface Visitor<TargetType> {
	void accept(TargetType tgt);
}
