package com.rosaloves.bitlyj.data;

/**
 * Pair
 * 
 * $Id$
 * 
 * @author clewis Jul 19, 2010
 *
 */
public final class Pair<A, B> {
	
	private final A one;
	
	private final B two;

	public static <A, B> Pair<A, B> p(A one, B two) {
		return new Pair<A, B>(one, two);
	}
	
	public Pair(A one, B two) {
		super();
		this.one = one;
		this.two = two;
	}

	public A getOne() {
		return one;
	}

	public B getTwo() {
		return two;
	}

	@Override
	public String toString() {
		return "Pair [one=" + one + ", two=" + two + "]";
	}
	
}
