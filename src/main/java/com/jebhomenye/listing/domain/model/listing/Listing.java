package com.jebhomenye.listing.domain.model.listing;

import java.util.LinkedHashSet;
import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.experimental.Accessors;

import org.joda.time.DateTime;

import com.jebhomenye.listing.domain.model.category.CategoryId;
import com.jebhomenye.listing.domain.model.user.UserId;
import com.jebhomenye.listing.domain.shared.Entity;

@Data
@Accessors(fluent=true)
@EqualsAndHashCode(exclude={"dateCreated", "dateUpdated"})
public class Listing implements Entity<Listing> {
	@NonNull private final ListingId listingId;
	@NonNull private final String name;
	@NonNull private final UserId listedBy;
	private final DateTime dateCreated;
	
	private final Set<CategoryId> categories = new LinkedHashSet<CategoryId>();
	private final Set<byte[]> images = new LinkedHashSet<byte[]>();
	private final Set<Field> fields = new LinkedHashSet<Field>();
	private final Set<PromotionType> promotions = new LinkedHashSet<PromotionType>();
	private Location location;
	private DateTime dateUpdated;
	private boolean published;
	private long hits;
	
	public Listing(ListingId listingId, String name, UserId listedBy){
		dateCreated = DateTime.now();
		this.listingId = listingId;
		this.name = name;
		this.listedBy = listedBy;
	}
	
	public void addImage(byte[] image){
		images.add(image);
	}
	
	public void addCategory(CategoryId category){
		categories.add(category);
	}
	
	public void addField(Field field){
		fields.add(field);
	}
	
	public void addPromotion(PromotionType promotionType){
		promotions.add(promotionType);
	}
	
	public boolean sameIdentityAs(Listing other) {
		return this.equals(other);
	}
	
	
	
}
