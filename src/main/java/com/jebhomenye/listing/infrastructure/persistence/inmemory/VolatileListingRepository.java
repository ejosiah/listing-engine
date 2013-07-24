package com.jebhomenye.listing.infrastructure.persistence.inmemory;

import java.util.Collection;

import javax.inject.Named;

import com.jebhomenye.listing.domain.model.listing.ExampleListing;
import com.jebhomenye.listing.domain.model.listing.Listing;
import com.jebhomenye.listing.domain.model.listing.ListingId;
import com.jebhomenye.listing.domain.model.listing.ListingRepository;
import com.jebhomenye.listing.domain.model.user.UserId;

@Named
public class VolatileListingRepository implements ListingRepository {

	public void add(Listing aListing) {
		// TODO Auto-generated method stub
		
	}

	public ListingId nextIdentity() {
		// TODO Auto-generated method stub
		return null;
	}

	public Listing listingOfId(ListingId aListingId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<Listing> listingsOfUser(UserId aUser) {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<Listing> retriveAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<Listing> listingsByExample(ExampleListing anExample) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
