package com.jebhomenye.listing.domain.model.category;

import lombok.Data;

import com.jebhomenye.listing.domain.shared.ValueObject;

@Data
public class Param implements ValueObject<Param> {
	private final String name;
	private final String value;
	
	public boolean sameValuesAs(Param other) {
		return this.equals(other);
	}
}
