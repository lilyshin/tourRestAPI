package com.project.tour;

import com.project.tour.entity.City;
import com.project.tour.repository.CityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class CityTests {
    @Autowired
    CityRepository cityRepository;

    @Test
    void save() {
        // 1. 도시 파라미터 생성
        City params = City.builder()
                .cityCd(3L)
                .cityNm("서울")
                .build();

        // 2. 도시 저장
        cityRepository.save(params);

        // 3. 도시 정보 조회
        City entity = cityRepository.findById(3L).get();
        assertThat(entity.getCityNm()).isEqualTo("서울");
    }

    @Test
    void findAll() {
        // 1. 전체 리스트 조회
        List<City> citys = cityRepository.findAll();
    }

    @Test
    void delete() {
        // 1. 조회
        City entity = cityRepository.findById(3L).get();

        // 2. 삭제
        cityRepository.delete(entity);
    }

}
