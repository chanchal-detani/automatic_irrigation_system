package com.banque.misr.irrigationsystem.enums;

import org.apache.commons.lang3.StringUtils;

public enum CropType {

	FOOD("FOOD"),
	FEED("FEED"),
	FIBER("FIBER"),
	OIL("OIL"),
	ORNAMENTAL("ORNAMENTAL"),
	INDUSTRIAL("INDUSTRIAL");
	
	private String crop;
	private CropType(String crop) {
		this.crop=crop;
	}

	public String getCrop() {
		return crop;
	}
	
	public static CropType fromValue(String cropType) {
		
		for(CropType temp : values()) {
			if(StringUtils.equalsIgnoreCase(temp.getCrop(), cropType))
				return temp;
		}
		throw new IllegalArgumentException("CropType with name '"+cropType+"' not found");
	}
}
