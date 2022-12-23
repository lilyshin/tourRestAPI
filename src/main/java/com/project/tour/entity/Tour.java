package com.project.tour.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tourCd;

    private String tourNm;

    @ManyToOne
    @Setter
    @JoinColumn(name="cityCd")
    private City city;

    @Transient
    private Long cityCd;

    private String tourStartDate;

    private String tourEndDate;

    @ManyToOne
    @Setter
    @JoinColumn(name="userId")
    private User user;

    @Transient
    private String userId;

    @Builder
    public Tour(Long tourCd, String tourNm, City city, String tourStartDate, String tourEndDate) {
        this.tourCd = tourCd;
        this.tourNm = tourNm;
        this.city = city;
        this.tourStartDate = tourStartDate;
        this.tourEndDate = tourEndDate;
    }

}
