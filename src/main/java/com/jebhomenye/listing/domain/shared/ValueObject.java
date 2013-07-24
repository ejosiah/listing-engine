package com.jebhomenye.listing.domain.shared;

public interface ValueObject<T> {
	
	boolean sameValuesAs(T other);
}
