package com.jebhomenye.listing.domain.model.category;

import lombok.Data;
import lombok.experimental.Accessors;

import com.jebhomenye.domain.common.core.Identity;
import com.jebhomenye.domain.common.core.ValueObject;

@Data
@Accessors(fluent=true)
public class CategoryId implements ValueObject<CategoryId>, Identity<String> {

	private static final long serialVersionUID = 1L;
	private final String id;

	public boolean sameValuesAs(CategoryId other) {
		return this.equals(other);
	}

}
