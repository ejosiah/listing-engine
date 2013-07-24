package com.jebhomenye.listing.domain.model.user;

import lombok.Data;
import lombok.experimental.Accessors;

import com.jebhomenye.listing.domain.shared.Entity;

@Data
@Accessors(fluent=true)
public class User implements Entity<User> {
	private final UserId id;
	private final String username;

	public boolean sameIdentityAs(User other) {
		return false;
	}

}
