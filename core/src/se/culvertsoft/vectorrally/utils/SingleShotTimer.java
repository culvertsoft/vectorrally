package se.culvertsoft.vectorrally.utils;

public class SingleShotTimer {

	private final double m_tStart;
	private final double m_tNext;

	public SingleShotTimer(double dt) {
		m_tStart = Time.seconds();
		m_tNext = Time.seconds() + dt;
	}

	public boolean poll() {
		return delta() >= tNext();
	}

	public double tStart() {
		return m_tStart;
	}

	public double tNext() {
		return m_tNext;
	}

	public double delta() {
		return Time.seconds() - tStart();
	}

}
