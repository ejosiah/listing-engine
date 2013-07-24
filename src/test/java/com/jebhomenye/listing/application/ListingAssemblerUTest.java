package com.jebhomenye.listing.application;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.jebhomenye.listing.domain.model.category.CategoryId;
import com.jebhomenye.listing.domain.model.listing.Field;
import com.jebhomenye.listing.domain.model.listing.Listing;
import com.jebhomenye.listing.domain.model.listing.ListingId;
import com.jebhomenye.listing.domain.model.listing.ListingRepository;
import com.jebhomenye.listing.domain.model.listing.Location;
import com.jebhomenye.listing.domain.model.user.UserId;
import com.jebhomenye.listing.id.UUIDGenerator;

@RunWith(MockitoJUnitRunner.class)
public class ListingAssemblerUTest {
	private static final UUIDGenerator idGenerator = new UUIDGenerator();
	private static final ListingId LISTING_ID = new ListingId(idGenerator.generateId());
	private static final String USER_ID = idGenerator.generateId();
	private static final String CATEGORY_ID = idGenerator.generateId();
	
	private static final Map<String, Object> fields = new HashMap<String, Object>();
	
	static{
		fields.put("Make", "Mercedes");
		fields.put("Model", "C200 KOMPRESSOR");
		fields.put("Year", 2003);
		fields.put("Mileage", 94808);
		fields.put("Seller type", "private");
		fields.put("Body type", "Coupe");
		fields.put("Fuel type", "Petrol");
		fields.put("Transmission", "Manual");
		fields.put("color", "Black");
		fields.put("Engine size", 1796);
		
	}
	
	@Mock CreateListingCommand createListingCommand;
	@Mock ListingQuery listingQuery;
	@Mock ListingRepository listingRepository;
	
	@InjectMocks ListingAssembler listingAssembler;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAssembleFrom() {
		when(listingRepository.nextIdentity()).thenReturn(LISTING_ID);
		when(createListingCommand.getName()).thenReturn("Mercedes C180 Kompressor");
		when(createListingCommand.getUserId()).thenReturn(USER_ID);
		when(createListingCommand.getCategories()).thenReturn(Arrays.asList(CATEGORY_ID));
		when(createListingCommand.getFields()).thenReturn(fields);
		when(createListingCommand.getCountry()).thenReturn("Nigeria");
		when(createListingCommand.getCity()).thenReturn("Lagos");
		
		Listing expected = createdListing();
		
		Listing actual = listingAssembler.assembleFrom(createListingCommand);
		
		assertEquals(expected, actual);
	}
	
	private Listing createdListing(){
		Listing listing = new Listing(LISTING_ID, "Mercedes C180 Kompressor", new UserId(USER_ID));
		listing.addCategory(new CategoryId(CATEGORY_ID));
		
		for(Entry<String, Object> entry : fields.entrySet()){
			listing.addField(new Field(entry.getKey(), entry.getValue()));
		}
		listing.location(new Location("Nigeria", "Lagos"));
		return listing;
	}
	
	@Test
	public void testAssembleExampleListingFrom(){
		fail("Not yet implemented!");
	}
}
