package com.banque.misr.irrigationsystem.enums;

import org.apache.commons.lang3.StringUtils;

public enum MeasuringUnit {

	SQUARE_FEET("SQUARE_FEET"),
	SQUARE_CENTIMETER("SQUARE_CENTIMETER"),
	SQUARE_INCH("SQUARE_INCH"),
	SQUARE_KILOMETER("SQUARE_KILOMETER"),
	SQUARE_METER("SQUARE_METER"),
	SQUARE_MILE("SQUARE_MILE"),
	SQUARE_YARD("SQUARE_YARD"),
	ACRE("ACRE"),
	BIGHA("BIGHA"),
	BISWA("BISWA"),
	KILLA("KILLA"),
	GHUMAON("GHUMAON"),
	KANAL("KANAL"),
	CHATAK("CHATAK"),
	KATTHA("KATTHA");
	
	private String unit = null;
	private MeasuringUnit(String unit) {
		this.unit = unit;
	}
	public String getUnit() {
		return unit;
	}
	
	public static MeasuringUnit fromValue(String measuringUnit) {
		
		for(MeasuringUnit temp : values()) {
			if(StringUtils.equalsIgnoreCase(temp.getUnit(), measuringUnit)) {}
				return temp;
		}
		throw new IllegalArgumentException("MeasuringUnit with name '"+measuringUnit+"' not found");
	}
}
