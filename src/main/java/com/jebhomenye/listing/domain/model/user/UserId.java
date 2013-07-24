package com.jebhomenye.listing.domain.model.user;

import lombok.Data;
import lombok.experimental.Accessors;

import com.jebhomenye.listing.domain.shared.Identity;
import com.jebhomenye.listing.domain.shared.ValueObject;

@Data
@Accessors(fluent=true)
public class UserId implements ValueObject<UserId>, Identity<String> {
	private final String id;

	public boolean sameValuesAs(UserId other) {
		return this.equals(other);
	}

}
