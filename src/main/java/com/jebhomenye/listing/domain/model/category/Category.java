package com.jebhomenye.listing.domain.model.category;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.NonNull;
import lombok.experimental.Accessors;

import org.joda.time.DateTime;

import com.jebhomenye.listing.domain.shared.Entity;

@Data
@Accessors(fluent=true)
public class Category implements Entity<Category> {
	@NonNull private final CategoryId categoryId;
	@NonNull private final String name;
	@NonNull private final DateTime dateCreated;
	private String description;
	private DateTime lastUpdated;
	private boolean published;
	private long hits;
	private Category parentCategory;
	private final Set<MetaData> metaData = new HashSet<MetaData>();
	private final Set<Category> childCategories = new HashSet<Category>();
	
	public void addMetaData(MetaData metaData){
		metaData().add(metaData);
	}
	
	public void addchildCategories(Category category){
		category.parentCategory(this);
		childCategories.add(category);
	}
	
	public boolean sameIdentityAs(Category other) {
		return this.categoryId().sameValuesAs(other.categoryId());
	}
	
	public Set<MetaData> metaData(){
		return new HashSet<MetaData>(metaData);
	}
	
	public Set<Category> childCategories(){
		return new HashSet<Category>(childCategories);
	}

}
