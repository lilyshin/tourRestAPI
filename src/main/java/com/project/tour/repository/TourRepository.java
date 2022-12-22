package com.project.tour.repository;

import com.project.tour.entity.City;
import com.project.tour.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends JpaRepository<Tour, Long> {
}
