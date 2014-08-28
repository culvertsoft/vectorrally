package se.culvertsoft.vectorrally.utils;

public class RepeatedTimer {

	private final double m_dt;
	private final double m_tStart;
	private double m_tReset;
	private double m_tNext;

	public RepeatedTimer(double dt, boolean waitFirst) {
		m_tStart = Time.seconds();
		m_tReset = m_tStart;
		m_dt = dt;
		m_tNext = m_tStart + (waitFirst ? dt : 0.0);
	}

	public RepeatedTimer(double dt) {
		this(dt, false);
	}

	public double tStart() {
		return m_tStart;
	}

	public double tReset() {
		return m_tReset;
	}

	public double tNext() {
		return m_tNext;
	}

	public double delta() {
		return Time.seconds() - m_tReset;
	}

	public boolean poll() {
		double t = Time.seconds();
		if (t >= m_tNext) {
			m_tReset = t;
			m_tNext += m_dt;
			return true;
		} else {
			return false;
		}
	}

}
