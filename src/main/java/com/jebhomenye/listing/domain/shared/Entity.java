package com.jebhomenye.listing.domain.shared;

public interface Entity<T> {
	
	boolean sameIdentityAs(T other);
}
