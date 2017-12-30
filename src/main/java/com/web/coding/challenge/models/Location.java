package com.web.coding.challenge.models;

import java.util.ArrayList;
import java.util.List;

public class Location {
	private String type;
	private List<Double> coordinates;
	
	public Location() {
		super();
		this.coordinates=new ArrayList<Double>();
	}

	public Location(String type, List<Double> coordinates) {
		super();
		this.type = type;
		this.coordinates = coordinates;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Double> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<Double> coordinates) {
		this.coordinates = coordinates;
	}

	@Override
	public String toString() {
		return "Location [type=" + type + ", coordinates=" + coordinates + "]";
	}
}
