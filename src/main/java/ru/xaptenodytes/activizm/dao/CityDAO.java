package ru.xaptenodytes.activizm.dao;

import ru.xaptenodytes.activizm.model.City;

public interface CityDAO {
	
	public City getCityById(int id);
	
	public City getCityByName(String cityName);
}
