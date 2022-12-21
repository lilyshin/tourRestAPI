package com.project.tour.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Entity
@NoArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cityCd;

    private String cityNm;

    @CreatedDate
    private LocalDateTime regDate;

    @PrePersist
    protected void prePersist() {
        if (this.regDate == null) regDate = LocalDateTime.now();
    }

    @Builder
    public City(Long cityCd, String cityNm, LocalDateTime regDate) {
        this.cityCd = cityCd;
        this.cityNm = cityNm;
        this.regDate = regDate;
    }

}
