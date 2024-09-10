package com.fitmanager.system.application.presentation;

import java.time.LocalDateTime;

import com.fitmanager.system.domain.Goal.GoalStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoalDTO {
    private String id;
    private String description;
    private double progress;
    private GoalStatus status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}