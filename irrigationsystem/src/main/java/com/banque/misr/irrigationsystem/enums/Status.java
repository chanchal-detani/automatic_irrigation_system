package com.banque.misr.irrigationsystem.enums;

import org.apache.commons.lang3.StringUtils;

public enum Status {

	// plot specific statuses
	ACTIVE("ACTIVE"),
	INACTIVE("INACTIVE"),
	ELIGIBLE_FOR_IRRIGATION("ELIGIBLE_FOR_IRRIGATION"),
	UNDER_MAINTENANCE("UNDER_MAINTENANCE"),
	
	// irrigation timings specific statuses
	YET_TO_BE_SCHEDULED("YET_TO_BE_SCHEDULED"),
	SCHEDULED("SCHEDULED"),
	REQUESTED_FOR_IRRIGATION("REQUESTED_FOR_IRRIGATION"),
	IRRIGATED_SUCCESSFULLY("IRRIGATED_SUCCESSFULLY"),
	IRRIGATION_FAILED("IRRIGATION_FAILED"),
	
	;
	
	private String name = null;
	private Status(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	
	public static Status fromValue(String status) {
		
		for(Status temp : values()) {
			if(StringUtils.equalsIgnoreCase(temp.getName(), status))
				return temp;
		}
		throw new IllegalArgumentException("Status with name '"+status+"' not found");
	}
}
