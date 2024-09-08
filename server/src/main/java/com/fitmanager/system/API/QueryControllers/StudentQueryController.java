package com.fitmanager.system.API.QueryControllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitmanager.system.application.mappers.StudentMapper;
import com.fitmanager.system.application.presentation.StudentDTO;
import com.fitmanager.system.application.query.StudentQueryService;

@RestController
@RequestMapping("student")
public class StudentQueryController {

    private final StudentQueryService studentQueryService;
    private final StudentMapper studentMapper;

    @Autowired
    public StudentQueryController(
            final StudentQueryService studentQueryService,
            final StudentMapper studentMapper) {
        this.studentQueryService = studentQueryService;
        this.studentMapper = studentMapper;
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> findAll() {
        var students = studentQueryService.findAll();
        List<StudentDTO> formmatedStudents = students.stream()
                .map(this.studentMapper::StudentToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(formmatedStudents);
    }
}
