package com.jebhomenye.listing.domain.model.listing;

import lombok.Data;
import lombok.experimental.Accessors;

import com.jebhomenye.domain.common.core.ValueObject;

@Data
@Accessors(fluent=true)
public class Field implements ValueObject<Field> {
	private final String name;
	private final Object value;
	
	public boolean sameValuesAs(Field other) {
		return this.equals(other);
	}
}
