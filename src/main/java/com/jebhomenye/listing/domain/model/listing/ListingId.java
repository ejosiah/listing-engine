package com.jebhomenye.listing.domain.model.listing;

import lombok.Data;
import lombok.experimental.Accessors;

import com.jebhomenye.domain.common.core.Identity;
import com.jebhomenye.domain.common.core.ValueObject;

@Data
@Accessors(fluent=true)
public class ListingId implements Identity<String>, ValueObject<ListingId>{
	private final String id;
	
	public boolean sameValuesAs(ListingId other) {
		return this.equals(other);
	}
}
