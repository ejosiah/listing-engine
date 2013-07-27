package com.jebhomenye.listing.domain.model.listing;

import com.jebhomenye.domain.common.core.ValueObject;

public enum PromotionType implements ValueObject<PromotionType> {
	URGENT,
	FEATURED,
	SPOTLIGHT;

	public boolean sameValuesAs(PromotionType other) {
		return this.equals(other);
	}
	
}
