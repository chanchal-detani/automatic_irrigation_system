package com.banque.misr.irrigationsystem;

public class BaseDataBuilder {

	// create plot related request json
	protected final String PLOT_REQUEST = "{\"measuringUnit\":\"SQUARE_METER\",\"name\":\"TestingPlotAddition\",\"description\":\"TestingPlotAddition description\",\"sensor\":{\"id\":1},\"cropType\":\"FOOD\",\"plotArea\":12,\"status\":\"ACTIVE\"}";
	protected final String PLOT_REQUEST_MISSING_NAME = "{\"measuringUnit\":\"SQUARE_METER\",\"description\":\"TestingPlotAddition description\",\"sensor\":{\"id\":1},\"cropType\":\"FOOD\",\"plotArea\":12,\"status\":\"ACTIVE\"}";
	protected final String PLOT_REQUEST_INVALID_ENUM_VALUE = "{\"measuringUnit\":\"SQUARE_METER\",\"name\":\"TestingPlotAddition\",\"description\":\"TestingPlotAddition description\",\"sensor\":{\"id\":1},\"cropType\":\"FOOD\",\"plotArea\":12,\"status\":\"ACACTIVE\"}";
	protected final String PLOT_REQUEST_SENSOR_NOT_FOUND = "{\"measuringUnit\":\"SQUARE_METER\",\"name\":\"TestingPlotAddition\",\"description\":\"TestingPlotAddition description\",\"cropType\":\"FOOD\",\"plotArea\":12,\"status\":\"ACTIVE\"}";
	protected final String PLOT_REQUEST_SENSOR_INVALID = "{\"measuringUnit\":\"SQUARE_METER\",\"name\":\"TestingPlotAddition\",\"description\":\"TestingPlotAddition description\",\"sensor\":{\"id\":1111},\"cropType\":\"FOOD\",\"plotArea\":12,\"status\":\"ACTIVE\"}";
	protected final String PLOT_REQUEST_DUPLICATE_NAME = "{\"measuringUnit\":\"SQUARE_METER\",\"name\":\"1st Plot\",\"description\":\"TestingPlotAddition description\",\"sensor\":{\"id\":1},\"cropType\":\"FOOD\",\"plotArea\":12,\"status\":\"ACTIVE\"}";
	
	// update plot related request json
	protected final String PLOT_UPDATE_REQUEST = "{\"measuringUnit\":\"SQUARE_METER\",\"name\":\"1st Plot\",\"description\":\"TestingPlotAddition description\",\"sensor\":{\"id\":1},\"cropType\":\"FOOD\",\"plotArea\":12,\"status\":\"ACTIVE\"}";
	
	// irrigation timings related request json
	protected final String IRRIGATION_TIMING_REQUEST = "{\"startAt\":\"Mon Nov 16 00:00:00 IST 2022\",\"endsAt\":\"Mon Nov 16 01:00:00 IST 2022\",\"amountOfWater\":10}";
	protected final String IRRIGATION_TIMING_REQUEST_MISSING_FIELD = "{\"startAt\":\"Mon Nov 16 00:00:00 IST 2022\",\"endsAt\":\"Mon Nov 16 01:00:00 IST 2022\"}";
}
