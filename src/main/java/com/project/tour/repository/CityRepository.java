package com.project.tour.repository;

import com.project.tour.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    /*@Query(nativeQuery = true)
    public List<City> findListByUserId(String userId);*/
}
