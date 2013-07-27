package com.jebhomenye.listing.domain.model.listing;

import lombok.Data;
import lombok.experimental.Accessors;

import com.jebhomenye.domain.common.core.ValueObject;

@Data
@Accessors(fluent=true)
public class Location implements ValueObject<Location> {
	private final String country;
	private final String city;
	
	public boolean sameValuesAs(Location other) {
		return this.equals(other);
	}
}
