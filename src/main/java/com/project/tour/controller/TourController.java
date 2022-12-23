package com.project.tour.controller;

import com.project.tour.entity.Tour;
import com.project.tour.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class TourController {

    private final TourService tourService;

    @GetMapping("/tour")
    public List<Tour> getTourList(){
        return tourService.findAll();
    }

    @PostMapping("/tour/create")
    public ResponseEntity createTour(@RequestBody Tour tour) {
        Tour entity = tourService.save(tour);
        Map result = new HashMap<String, Object>();
        result.put("data", entity);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/tour/update")
    public ResponseEntity updateTour(@RequestBody Tour tour) {
        Tour entity = tourService.update(tour);
        Map result = new HashMap<String, Object>();
        result.put("data", entity);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/tour/delete/{tourCd}")
    public ResponseEntity deleteTour(@PathVariable("tourCd") Long tourCd) {
        tourService.delete(tourCd);

        return new ResponseEntity<>(new HashMap<String, Object>(), HttpStatus.OK);
    }

}