package se.culvertsoft.vectorrally.utils;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class W<T, L extends Iterable<T>> {

	private final L m_ts;

	public W(final L ts) {
		m_ts = ts;
	}

	public static <T, L extends Iterable<T>> W<T, L> £(final L ts) {
		return new W<T, L>(ts);
	}

	public Optional<T> find(Function<T, Boolean> f) {
		return Utils.find(m_ts, f);
	}

	public boolean contains(Function<T, Boolean> f) {
		return find(f).isPresent();
	}

	public <R> W<R, List<R>> map(Function<T, R> f) {
		return £(Utils.map(m_ts, f));
	}

	public W<T, List<T>> filter(Function<T, Boolean> f) {
		return £(Utils.filter(m_ts, f));
	}

	public Optional<T> headOption() {
		return Utils.head(m_ts);
	}

	public T head() {
		return headOption().get();
	}
	
	public L get() {
		return m_ts;
	}

}
