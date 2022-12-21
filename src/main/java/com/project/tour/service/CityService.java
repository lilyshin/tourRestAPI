package com.project.tour.service;

import com.project.tour.entity.City;
import com.project.tour.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CityService {
    private final CityRepository cityRepository;

    public List<City> findAll() {
        List<City> list = (List<City>) cityRepository.findAll();
        return list;
    }

    public void save(City city) {
        cityRepository.save(city);
    }

    public List<City> findAllByUser(String userId) {
        return null;
    }
}