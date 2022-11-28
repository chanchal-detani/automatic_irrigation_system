package com.banque.misr.irrigationsystem.service;

import com.banque.misr.irrigationsystem.model.Plot;
import com.banque.misr.irrigationsystem.model.PlotRequest;
import com.banque.misr.irrigationsystem.model.PlotsPage;

public interface PlotService {

	public Plot createPlot(PlotRequest createPlotRequest);
	public Plot updatePlot(long id, PlotRequest updatePlotRequest);
	public void deletePlot(long id);
	public PlotsPage listPlots(Integer pageSize, Integer offSet, String sortBy, String orderBy, String name, String description, String status, String cropType);
}
