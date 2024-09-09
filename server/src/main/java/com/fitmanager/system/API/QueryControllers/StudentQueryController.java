package com.fitmanager.system.API.QueryControllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitmanager.system.application.mappers.StudentMapper;
import com.fitmanager.system.application.presentation.StudentDTO;
import com.fitmanager.system.application.query.StudentQueryService;
import com.fitmanager.system.application.query.records.FindOneStudentQuery;
import com.fitmanager.system.domain.Student.Student;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("student")
public class StudentQueryController {

    private final StudentQueryService studentQueryService;
    private final StudentMapper studentMapper;

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

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> findOne(@Validated @PathVariable String id) {
        var query = new FindOneStudentQuery(id);
        Optional<Student> savedStudent = studentQueryService.findOne(query);
        StudentDTO convertedStudent = studentMapper.StudentToDTO(savedStudent.get());
        return ResponseEntity.ok().body(convertedStudent);
    }
}
