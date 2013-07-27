package com.jebhomenye.listing.domain.model.category;

import java.util.HashSet;
import java.util.Set;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.Accessors;

import com.jebhomenye.domain.common.core.ValueObject;

@Data
@Accessors(fluent=true)
public class MetaData implements ValueObject<MetaData> {
	private final String name;
	
	@Getter(value=AccessLevel.NONE)
	private final Set<String> options = new HashSet<String>();
	
	private String description;
	private boolean closed;
	
	public MetaData(String name){
		this.name = name;
	}
	
	public void addOption(String option){
		options.add(option);
	}

	public boolean sameValuesAs(MetaData other) {
		return this.equals(other);
	}

}
