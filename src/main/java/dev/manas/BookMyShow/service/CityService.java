package dev.manas.BookMyShow.service;

import dev.manas.BookMyShow.model.City;
import dev.manas.BookMyShow.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public City saveCity(City city)
    {
      return  cityRepository.save(city);

    }
    public City saveCity(String cityName)
    {
        City city = new City();
        city.setName(cityName);
        return cityRepository.save(city);
    }
    public boolean deleteCity(int cityID)
    {
        cityRepository.deleteById(cityID);
        return true;
    }
    public City findCityByName(String cityName)
    {
        City city  = cityRepository.findCityByName(cityName);
        return city;
    }
    public City findCityByID(int cityId)
    {
        City city = cityRepository.findById(cityId).get();
        return city;
    }
}
