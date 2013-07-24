package com.jebhomenye.listing.domain.model.listing;

import org.joda.time.DateTime;

import lombok.Data;
import lombok.experimental.Accessors;

import com.jebhomenye.listing.domain.model.category.CategoryId;
import com.jebhomenye.listing.domain.model.user.UserId;
import com.jebhomenye.listing.domain.shared.ValueObject;

@Data
@Accessors(fluent=true)
public class ExampleListing implements ValueObject<ExampleListing> {
	private String name;
	private DateTime dateCreated;
	private UserId listedBy;
	private CategoryId category;
	private Location location;
	private DateTime lastUpdated;

	public boolean sameValuesAs(ExampleListing other) {
		return this.equals(other);
	}

}
