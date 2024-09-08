package com.fitmanager.system.application.presentation;

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
    private EmailDTO email;
    private PhoneDTO phone;
    private List<GoalDTO> goals;
}
