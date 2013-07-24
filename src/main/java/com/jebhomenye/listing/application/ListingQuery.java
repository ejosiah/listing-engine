package com.jebhomenye.listing.application;

import lombok.Data;

import org.joda.time.DateTime;

import com.jebhomenye.listing.domain.model.listing.Location;
import com.jebhomenye.listing.domain.model.user.UserId;

@Data
public class ListingQuery {
	private String name;
	private String listedBy;
	private String category;
	private String country;
	private String city;
	
	public boolean hasLocation(){
		return country != null && city != null;
	}
}
