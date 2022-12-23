package com.project.tour.service;

import com.project.tour.entity.City;
import com.project.tour.entity.Tour;
import com.project.tour.entity.User;
import com.project.tour.repository.TourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TourService {
    private final TourRepository tourRepository;
    private final CityService cityService;
    private final UserService userService;

    public List<Tour> findAll() {
        List<Tour> list = (List<Tour>) tourRepository.findAll();
        return list;
    }

    @Transactional
    public Tour save(Tour tour) {
        Optional<City> cityEntity = cityService.findById(tour.getCityCd());
        if (cityEntity.isEmpty()) {
            throw new IllegalArgumentException("도시코드를 확인해 주세요.");
        }
        tour.setCity(cityEntity.get());

        Optional<User> userEntity = userService.findById(tour.getUserId());
        if (userEntity.isEmpty()) {
            throw new IllegalArgumentException("사용자Id를 확인해 주세요.");
        }
        tour.setUser(userEntity.get());

        Tour result = tourRepository.save(tour);
        return result;
    }

    public Tour update(Tour tour) {
        Optional<Tour> tourEntity = tourRepository.findById(tour.getTourCd());
        if (tourEntity.isEmpty()) {
            throw new IllegalArgumentException("여행지코드를 확인해 주세요.");
        }

        Optional<City> cityEntity = cityService.findById(tour.getCityCd());
        if (cityEntity.isEmpty()) {
            throw new IllegalArgumentException("도시코드를 확인해 주세요.");
        }
        tour.setCity(cityEntity.get());

        Tour result = tourRepository.save(tour);
        return result;
    }

    public void delete(Long tourCd) {
        Optional<Tour> entity = tourRepository.findById(tourCd);
        if (entity.isEmpty()) {
            throw new IllegalArgumentException("도시코드를 확인해 주세요.");
        }

        tourRepository.deleteById(tourCd);
    }

}