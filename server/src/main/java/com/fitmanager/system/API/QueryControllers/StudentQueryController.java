package com.fitmanager.system.API.QueryControllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitmanager.system.application.presentation.EmailDTO;
import com.fitmanager.system.application.presentation.GoalDTO;
import com.fitmanager.system.application.presentation.PhoneDTO;
import com.fitmanager.system.application.presentation.StudentDTO;
import com.fitmanager.system.application.query.StudentQueryService;
import com.fitmanager.system.domain.Student.Student;

@RestController
@RequestMapping("student")
public class StudentQueryController {

    private final StudentQueryService studentQueryService;

    @Autowired
    public StudentQueryController(final StudentQueryService studentQueryService) {
        this.studentQueryService = studentQueryService;
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> findAll() {
        var students = studentQueryService.findAll();
        List<StudentDTO> formmatedStudents = students.stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
        return ResponseEntity.ok().body(formmatedStudents);
    }

    private StudentDTO convertToDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(new EmailDTO(student.getEmail().unwrap()));
        dto.setPhone(new PhoneDTO(student.getPhone().unwrap()));
        dto.setGoals(student.getGoals().stream()
                .map(goal -> {
                    GoalDTO goalDTO = new GoalDTO();
                    goalDTO.setId(goal.getId());
                    goalDTO.setDescription(goal.getDescription());
                    goalDTO.setStartDate(goal.getStartDate());
                    return goalDTO;
                })
                .collect(Collectors.toList()));
        return dto;
    }
}
