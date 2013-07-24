package com.jebhomenye.listing.domain.model.listing;

import java.util.Collection;
import java.util.Map;

import com.jebhomenye.listing.domain.model.user.UserId;

public interface ListingRepository {
	
	void add(Listing aListing);
	
	ListingId nextIdentity();
	
	Listing listingOfId(ListingId aListingId);
	
	Collection<Listing> listingsOfUser(UserId aUser);
	
	Collection<Listing> retriveAll();
	
	Collection<Listing> listingsByExample(ExampleListing anExample);
}
