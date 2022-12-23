package com.project.tour.repository;

import com.project.tour.entity.City;
import com.project.tour.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TourRepository extends JpaRepository<Tour, Long> {
}
