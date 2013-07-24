package com.jebhomenye.listing.domain.model.category;

import java.util.Collection;

import com.jebhomenye.listing.domain.model.user.UserId;

public interface CategoryRepository {
	
	void add(Category aCategory);
	
	CategoryId nextIdentity();
	
	Category CategoryOfId(CategoryId aCategory);
	
	Collection<Category> retriveAll();
}
