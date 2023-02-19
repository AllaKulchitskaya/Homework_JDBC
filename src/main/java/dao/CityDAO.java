package dao;

import entity.City;

import java.util.List;

public interface CityDAO {
    void createCity(City city);

    City getCityById(int cityId);

    List<City> getAllCities();

    void updateCity(City city);

    void deleteCity(City city);
}
