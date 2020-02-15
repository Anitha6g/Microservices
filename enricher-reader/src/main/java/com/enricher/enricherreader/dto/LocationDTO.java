package com.enricher.enricherreader.dto;

import com.opencsv.bean.CsvBindByName;

public class LocationDTO {

	@CsvBindByName(column = "LocationID")
	public int locationID;
	@CsvBindByName(column = "Borough")
	public String borough;
	@CsvBindByName(column = "Zone")
	public String zone;
	@CsvBindByName(column = "service_zone")
	public String serviceZone;
	
	public int getLocationID() {
		return locationID;
	}
	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}
	public String getBorough() {
		return borough;
	}
	public void setBorough(String borough) {
		this.borough = borough;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public String getServiceZone() {
		return serviceZone;
	}
	public void setServiceZone(String serviceZone) {
		this.serviceZone = serviceZone;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LocationDTO [locationID=").append(locationID).append(", borough=").append(borough)
				.append(", zone=").append(zone).append(", serviceZone=").append(serviceZone).append("]");
		return builder.toString();
	}
	
	
}
