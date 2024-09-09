package com.fitmanager.system.application.presentation;

import java.time.LocalDateTime;
import java.util.List;

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
}
