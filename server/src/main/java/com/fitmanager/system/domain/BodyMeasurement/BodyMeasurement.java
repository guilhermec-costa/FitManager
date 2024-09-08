package com.fitmanager.system.domain.BodyMeasurement;

import java.time.LocalDateTime;

import com.fitmanager.system.domain.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table
public class BodyMeasurement extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "measurement_date")
    private LocalDateTime measurementDate;

    @Column
    private double weight;

    @Column
    private double heigth;

    @Column(name = "body_fat_percentage")
    private double bodyFatPercentage;

    @Column(name = "chest_circumference")
    private double chestCircumference;
}
