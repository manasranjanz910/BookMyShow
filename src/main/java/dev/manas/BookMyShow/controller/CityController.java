package dev.manas.BookMyShow.controller;

import dev.manas.BookMyShow.dto.CityRequestDto;
import dev.manas.BookMyShow.model.City;
import dev.manas.BookMyShow.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CityController {
    @Autowired
    private CityService cityService;

    @PostMapping("/createCity")
    public ResponseEntity saveCity(@RequestBody CityRequestDto cityRequestDto)
    {
       String cityName = cityRequestDto.getName();
       try
       {
           if (cityName == null || cityName.isEmpty()|| cityName.isBlank())
           {
               throw new Exception("Invalid City Name");
           }
           City savedCity =  cityService.saveCity(cityName);
           return ResponseEntity.ok(savedCity);
       }
       catch(Exception e )
       {
           e.printStackTrace();
       }
       return null;
    }
    @DeleteMapping("/deleteCity/{id}")
    public ResponseEntity deleteCity(@PathVariable("id")int id)
    {
         boolean isTrue = cityService.deleteCity(id);
         return ResponseEntity.ok(isTrue);
    }

    @GetMapping("/getCity/{cityName}")
    public ResponseEntity findCItyByName(@PathVariable("cityName") String cityName)
    {
        City cityFound = cityService.findCityByName(cityName);
        return ResponseEntity.ok(cityFound);

    }

    @GetMapping("/getcity/{cityId}")
    public ResponseEntity findCityById(@PathVariable("cityId") int cityId)
    {
        City city = cityService.findCityByID(cityId);
        return ResponseEntity.ok(city);
    }


}
