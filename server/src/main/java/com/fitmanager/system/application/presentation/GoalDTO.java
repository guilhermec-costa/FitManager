package com.fitmanager.system.application.presentation;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoalDTO {
    private String id;
    private String description;
    private LocalDateTime startDate;
}