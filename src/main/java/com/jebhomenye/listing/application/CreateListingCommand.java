package com.jebhomenye.listing.application;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import lombok.Data;

@Data
public class CreateListingCommand {
	private String name;
	private String userId;
	private Collection<String> categories = new LinkedHashSet<String>();
	private Collection<byte[]> images = new LinkedHashSet<byte[]>();
	private Map<String, Object> fields = new HashMap<String, Object>();
	private String country;
	private String city;
	
}
