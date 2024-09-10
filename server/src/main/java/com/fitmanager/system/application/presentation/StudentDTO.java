package com.fitmanager.system.application.presentation;

import java.time.LocalDateTime;
import java.util.List;

import com.fitmanager.system.domain.BodyMeasurement.BodyMeasurement;
import com.fitmanager.system.domain.Diet.Diet;
import com.fitmanager.system.domain.Training.Training;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private String id;
    private String name;
    private String email;
    private String phone;
    private LocalDateTime birthDate;
    private List<GoalDTO> goals;
    private List<BodyMeasurement> bodyMeasurements;
    private List<Training> trainings;
    private Diet diet;
}
