package com.fitmanager.system.API.CommandControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitmanager.system.application.command.StudentCommandService;
import com.fitmanager.system.application.command.records.CreateGoalCommand;
import com.fitmanager.system.application.command.records.CreateStudentCommand;

@RestController
@RequestMapping("student")
public class StudentCommandController {

    private final StudentCommandService studentService;

    @Autowired
    public StudentCommandController(final StudentCommandService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> register(@Validated @RequestBody CreateStudentCommand payload) {
        studentService.register(payload);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{studentId}/goal")
    public ResponseEntity<String> addGoal(
        @Validated @PathVariable("studentId") String studentId, 
        @Validated @RequestBody CreateGoalCommand goalPayload
    ) {
        studentService.addGoalToStudent(studentId, goalPayload);
        return ResponseEntity.ok().build();
    }
}
