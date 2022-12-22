package com.project.tour.entity;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cityCd;

    private String cityNm;

    @CreatedDate
    @Column(insertable=true, updatable=false)
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

    public void update(Long cityCd, String cityNm, LocalDateTime regDate) {
        this.cityCd = cityCd;
        this.cityNm = cityNm;
        this.regDate = LocalDateTime.now();
    }

}
