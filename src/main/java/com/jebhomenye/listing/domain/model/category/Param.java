package com.jebhomenye.listing.domain.model.category;

import lombok.Data;

import com.jebhomenye.domain.common.core.ValueObject;

@Data
public class Param implements ValueObject<Param> {
	private final String name;
	private final String value;
	
	public boolean sameValuesAs(Param other) {
		return this.equals(other);
	}
}
