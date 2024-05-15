package dev.manas.BookMyShow.service;

import dev.manas.BookMyShow.model.City;
import dev.manas.BookMyShow.model.Theatre;
import dev.manas.BookMyShow.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreService {
    @Autowired
    private TheatreRepository theatreRepository;
    @Autowired
    private CityService cityService;

    public Theatre createTheatre(String name, String address , int cityId)
    {

        Theatre theatre = new Theatre();
        theatre.setAddress(address);
        theatre.setName(name);
        Theatre savedTheatre = theatreRepository.save(theatre);
        City city = cityService.findCityByID(cityId);
        List<Theatre> theatres = city.getTheatres();
        theatres.add(savedTheatre);
        city.setTheatres(theatres);
        cityService.saveCity(city);

        return savedTheatre;

    }
}
