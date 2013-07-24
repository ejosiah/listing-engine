package com.jebhomenye.listing.id;

import java.util.UUID;

public class UUIDGenerator implements IDGenerator {

	public String generateId() {
		return UUID.randomUUID().toString().toUpperCase();
	}

}
