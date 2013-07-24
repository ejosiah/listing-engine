package com.jebhomenye.listing.application;

import java.util.Collection;

import com.jebhomenye.listing.domain.model.listing.Listing;
import com.jebhomenye.listing.domain.model.listing.ListingId;

public interface ListingService {
	
	ListingId newListing(CreateListingCommand createListingCommand);
	
	Collection<Listing> search(ListingQuery listingQuery);
}
