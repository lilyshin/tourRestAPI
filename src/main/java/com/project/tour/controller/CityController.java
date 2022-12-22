package com.project.tour.controller;

import com.project.tour.entity.City;
import com.project.tour.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class CityController {

    private final CityService cityService;

    @GetMapping("/city")
    public List<City> getCityList(){
        return cityService.findAll();
    }

    @GetMapping("/city/{userId}")
    public List<City> getUserCityList(@PathVariable("userId") String userId) {
        return cityService.findAllByUser(userId);
    }

    @PostMapping("/city/create")
    public ResponseEntity createCtiy(@RequestBody City city) {
        City entity = cityService.save(city);
        Map result = new HashMap<String, Object>();
        result.put("data", entity);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/city/update")
    public ResponseEntity updateCity(@RequestBody City city) {
        City entity = cityService.update(city);
        Map result = new HashMap<String, Object>();
        result.put("data", entity);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/city/delete/{cityCd}")
    public ResponseEntity deleteCity(@PathVariable("cityCd") Long cityCd) {
        cityService.delete(cityCd);

        return new ResponseEntity<>(new HashMap<String, Object>(), HttpStatus.OK);
    }

}
