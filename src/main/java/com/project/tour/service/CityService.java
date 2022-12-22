package com.project.tour.service;

import com.project.tour.entity.City;
import com.project.tour.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CityService {
    private final CityRepository cityRepository;

    public List<City> findAll() {
        List<City> list = (List<City>) cityRepository.findAll();
        return list;
    }

    @Transactional
    public City save(City city) {
        if (city.getCityNm().isEmpty()) {
            throw new IllegalArgumentException("도시명을 입력해 주세요.");
        }

        City result = cityRepository.save(city);
        return result;
    }

    public City update(City city) {
        Optional<City> entity = cityRepository.findById(city.getCityCd());
        if (entity.isEmpty()) {
            throw new IllegalArgumentException("도시코드를 확인해 주세요.");
        }

        City result = cityRepository.save(city);
        return result;
    }

    public void delete(Long cityCd) {
        Optional<City> entity = cityRepository.findById(cityCd);
        if (entity.isEmpty()) {
            throw new IllegalArgumentException("도시코드를 확인해 주세요.");
        }

        cityRepository.deleteById(cityCd);
    }

    public Optional<City> findById(Long cityCd) {
        Optional<City> entity = cityRepository.findById(cityCd);
        return entity;
    }

    public List<City> findAllByUser(String userId) {
        return null;
    }
}