package com.jebhomenye.listing.application;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.jebhomenye.listing.domain.model.category.CategoryId;
import com.jebhomenye.listing.domain.model.category.CategoryRepository;
import com.jebhomenye.listing.domain.model.listing.ExampleListing;
import com.jebhomenye.listing.domain.model.listing.Field;
import com.jebhomenye.listing.domain.model.listing.Listing;
import com.jebhomenye.listing.domain.model.listing.ListingId;
import com.jebhomenye.listing.domain.model.listing.ListingRepository;
import com.jebhomenye.listing.domain.model.listing.Location;
import com.jebhomenye.listing.domain.model.user.UserId;
import com.jebhomenye.listing.id.UUIDGenerator;

@RunWith(MockitoJUnitRunner.class)
public class ConcreteListingServiceUTest {
	private static final UUIDGenerator idGenerator = new UUIDGenerator();
	private static final ListingId LISTING_ID = new ListingId(idGenerator.nextID());
	private static final String USER_ID = idGenerator.nextID();
	private static final String CATEGORY_ID = idGenerator.nextID();
	
	
	@Mock ListingRepository listingRepository;
	@Mock CategoryRepository categoryRepository;
	@Mock ListingQuery listingQuery;
	@Mock CreateListingCommand createListingCommand;
	@Mock Collection<Listing> searchResults;
	@Mock Listing listing;
	@Mock ListingAssembler listingAssembler;
	
	@InjectMocks ConcreteListingService listingService;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testNewListing() {
		when(listingAssembler.assembleFrom(createListingCommand)).thenReturn(listing);
		when(listing.listingId()).thenReturn(LISTING_ID);
		
		ListingId expected = LISTING_ID; 
		ListingId actual = listingService.newListing(createListingCommand);
		
		verify(listingRepository).add(listing);
		assertEquals(expected, actual);
	}
	


	@Test
	public void testSearch() {
		ExampleListing anExample = new ExampleListing();
		anExample.category(new CategoryId(CATEGORY_ID));
		
		when(listingQuery.getCategory()).thenReturn("Cars");
		when(listingRepository.listingsByExample(anExample)).thenReturn(searchResults);
		when(categoryRepository.categoryIdForName("Cars")).thenReturn(new CategoryId(CATEGORY_ID));
		
		Collection<Listing> expected = searchResults;
		Collection<Listing> actual = listingService.search(listingQuery);
		
		assertEquals(expected, actual);
	}

}
