package com.enricher.enricherreader.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class CollisionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2173083327250745995L;
	private LocalDate crashDate;
	private String crashTime;
	private String borough;
	private String location;
	private String streetName;
	private int personInjured;
	private int personKilled;

	
	public LocalDate getCrashDate() {
		return crashDate;
	}
	public void setCrashDate(LocalDate crashDate) {
		this.crashDate = crashDate;
	}
	public String getCrashTime() {
		return crashTime;
	}
	public void setCrashTime(String crashTime) {
		this.crashTime = crashTime;
	}
	public String getBorough() {
		return borough;
	}
	public void setBorough(String borough) {
		this.borough = borough;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public int getPersonInjured() {
		return personInjured;
	}
	public void setPersonInjured(int personInjured) {
		this.personInjured = personInjured;
	}
	public int getPersonKilled() {
		return personKilled;
	}
	public void setPersonKilled(int personKilled) {
		this.personKilled = personKilled;
	}
	
//	@Override
//	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("CollisionDTO [crashDate=").append(crashDate).append(", crashTime=").append(crashTime)
//				.append(", borough=").append(borough).append(", location=").append(location).append(", streetName=")
//				.append(streetName).append(", offStreetName=").append(", personInjured=")
//				.append(personInjured).append(", personKilled=").append(personKilled).append("]");
//		return builder.toString();
//	}

}
