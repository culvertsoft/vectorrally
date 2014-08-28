package se.culvertsoft.vectorrally.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class Utils {

	public static <T> Optional<T> find(Iterable<T> ts, Function<T, Boolean> f) {
		for (final T t : ts) {
			if (f.apply(t)) {
				return Optional.of(t);
			}
		}
		return Optional.empty();
	}

	public static <T> Optional<T> find(T[] ts, Function<T, Boolean> f) {
		for (final T t : ts) {
			if (f.apply(t)) {
				return Optional.of(t);
			}
		}
		return Optional.empty();
	}

	public static <T> boolean contains(Iterable<T> ts, Function<T, Boolean> f) {
		return find(ts, f).isPresent();
	}

	public static <T> boolean contains(T[] ts, Function<T, Boolean> f) {
		return find(ts, f).isPresent();
	}

	public static <T, R> List<R> map(Iterable<T> ts, Function<T, R> f) {
		final ArrayList<R> out = new ArrayList<>();
		for (final T t : ts)
			out.add(f.apply(t));
		return out;
	}

	public static <T, R> List<R> map(T[] ts, Function<T, R> f) {
		return map(Arrays.asList(ts), f);
	}

	public static <T> List<T> filter(Iterable<T> ts, Function<T, Boolean> f) {
		final ArrayList<T> out = new ArrayList<>();
		for (final T t : ts) {
			if (f.apply(t)) {
				out.add(t);
			}
		}
		return out;
	}

	public static <T> List<T> filter(T[] ts, Function<T, Boolean> f) {
		return filter(Arrays.asList(ts), f);
	}

	public static <T> Optional<T> head(Iterable<T> ts) {
		for (final T t : ts)
			return Optional.of(t);
		return Optional.empty();
	}

	public static <T> Optional<T> head(T[] ts) {
		for (final T t : ts)
			return Optional.of(t);
		return Optional.empty();
	}

	public static <A, B> boolean areEqual(A a, B b) {
		if (a == null)
			return b == null;
		else
			return a == b || a.equals(b);
	}

}
