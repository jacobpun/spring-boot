package org.pk;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Store {

	@Id
	private BigInteger id;
	private String name;
	@GeoSpatialIndexed(name="location")
	private Point location;
	
	public Store(String name, Point location) {
		this.name = name;
		this.location = location;
	}
	
	public String getName () {
		return name;
	}
	
	public Point getLocation() {
		return location;
	}	
}
