package com.jebhomenye.listing.domain.model.category;

import lombok.Data;
import lombok.experimental.Accessors;

import com.jebhomenye.listing.domain.shared.Identity;
import com.jebhomenye.listing.domain.shared.ValueObject;

@Data
@Accessors(fluent=true)
public class CategoryId implements ValueObject<CategoryId>, Identity<String> {
	
	private final String id;

	public boolean sameValuesAs(CategoryId other) {
		return this.equals(other);
	}

}
