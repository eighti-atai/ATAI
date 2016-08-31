package com.atai.module.purch.dao;

import java.util.List;

import com.atai.module.purch.model.Location;

public interface LocationDao {

	public void addLocation(Location p);
	public void updateLocation(Location p);
	public List<Location> listLocations();
	public Location getLocationById(int id);
	public void removeLocation(int id);
}
