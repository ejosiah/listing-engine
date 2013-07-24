package com.jebhomenye.listing.application;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;
import javax.inject.Named;

import org.mockito.InjectMocks;

import com.jebhomenye.listing.domain.model.category.CategoryId;
import com.jebhomenye.listing.domain.model.category.CategoryRepository;
import com.jebhomenye.listing.domain.model.listing.ExampleListing;
import com.jebhomenye.listing.domain.model.listing.Field;
import com.jebhomenye.listing.domain.model.listing.Listing;
import com.jebhomenye.listing.domain.model.listing.ListingId;
import com.jebhomenye.listing.domain.model.listing.ListingRepository;
import com.jebhomenye.listing.domain.model.listing.Location;
import com.jebhomenye.listing.domain.model.user.UserId;

@Named
public class ConcreteListingService implements ListingService {
	
	@Inject private ListingRepository listingRepository;
	@Inject private CategoryRepository categoryRepository;
	@Inject private ListingAssembler listingAssembler;

	public ListingId newListing(CreateListingCommand createListingCommand) {
		
		Listing listing = listingAssembler.assembleFrom(createListingCommand);
		listingRepository.add(listing);
		
		return listing.listingId();
	}

	public Collection<Listing> search(ListingQuery query) {
		CategoryId aCategoryId = categoryRepository.categoryIdForName(query.getCategory());
		
		ExampleListing anExample = new ExampleListing();
		anExample.name(query.getName());
		anExample.category(aCategoryId);
		if(query.hasLocation()){
			anExample.location(new Location(query.getCountry(), query.getCity()));
		}
		if(query.getListedBy() != null){
			anExample.listedBy(new UserId(query.getListedBy()));
		}
		
		Collection<Listing> searchResults = listingRepository.listingsByExample(anExample);
		return searchResults;
	}

}
