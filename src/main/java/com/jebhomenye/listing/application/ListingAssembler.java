package com.jebhomenye.listing.application;

import java.util.Map.Entry;

import javax.inject.Inject;
import javax.inject.Named;

import com.jebhomenye.listing.domain.model.category.CategoryId;
import com.jebhomenye.listing.domain.model.listing.ExampleListing;
import com.jebhomenye.listing.domain.model.listing.Field;
import com.jebhomenye.listing.domain.model.listing.Listing;
import com.jebhomenye.listing.domain.model.listing.ListingId;
import com.jebhomenye.listing.domain.model.listing.ListingRepository;
import com.jebhomenye.listing.domain.model.listing.Location;
import com.jebhomenye.listing.domain.model.user.UserId;

@Named
public class ListingAssembler {
	@Inject private ListingRepository listingRepository;
	public Listing assembleFrom(CreateListingCommand fromCommand){
		ListingId listingId = listingRepository.nextIdentity();
		UserId listedBy = new UserId(fromCommand.getUserId());
		
		Listing toListing = new Listing(listingId, fromCommand.getName(), listedBy);
		addCategories(fromCommand, toListing);
		addImages(fromCommand, toListing);
		addFields(fromCommand, toListing);

		toListing.location(new Location(fromCommand.getCountry()
				, fromCommand.getCity()));
		
		return toListing;
	}
	
	private void addCategories(CreateListingCommand fromCommand, Listing toListing){
		for(String id : fromCommand.getCategories()){
			toListing.addCategory(new CategoryId(id));
		}	
	}
	
	private void addImages(CreateListingCommand fromCommand, Listing toListing){
		for(byte[] image : fromCommand.getImages()){
			toListing.addImage(image);
		}	
	}
	
	private void addFields(CreateListingCommand fromCommand, Listing toListing){
		for(Entry<String, Object> field : fromCommand.getFields().entrySet()){
			toListing.addField(new Field(field.getKey(), field.getValue()));
		}		
	}
	
	public ExampleListing assembleFrom(ListingQuery query){
		return null;
	}
}
