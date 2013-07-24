package com.jebhomenye.listing.domain.model.listing;

import java.util.LinkedHashSet;
import java.util.Set;

import lombok.Data;
import lombok.experimental.Accessors;

import org.joda.time.DateTime;

import com.jebhomenye.listing.domain.model.category.CategoryId;
import com.jebhomenye.listing.domain.model.user.UserId;
import com.jebhomenye.listing.domain.shared.Entity;

@Data
@Accessors(fluent=true)
public class Listing implements Entity<Listing> {
	private final ListingId listingId;
	private final String name;
	private final DateTime dateCreated;
	private final UserId listedBy;
	
	private final Set<CategoryId> categories = new LinkedHashSet<CategoryId>();
	private final Set<byte[]> images = new LinkedHashSet<byte[]>();
	private final Set<Field> fields = new LinkedHashSet<Field>();
	private Location location;
	private DateTime lastUpdated;
	private boolean published;
	private long hits;
	
	public void addImage(byte[] image){
		images.add(image);
	}
	
	public void addCategory(CategoryId category){
		categories.add(category);
	}
	
	public void addField(Field field){
		fields.add(field);
	}
	
	public boolean sameIdentityAs(Listing other) {
		return this.equals(other);
	}
	
	
	
}
