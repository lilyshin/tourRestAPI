package com.project.tour.controller;

import com.project.tour.entity.City;
import com.project.tour.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CityController {

    private final CityService cityService;

    @GetMapping("/city")
    public List<City> city(){
        return cityService.findAll();
    }

    @GetMapping("/city/{userId}")
    public List<City> getUserCityList(@PathVariable("userId") String userId) {
        return cityService.findAllByUser(userId);
    }

    @PostMapping("/city")
    public void save(@RequestBody City city) {
        cityService.save(city);
    }

}
