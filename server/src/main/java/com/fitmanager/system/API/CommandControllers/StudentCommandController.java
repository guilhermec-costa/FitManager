package com.fitmanager.system.API.CommandControllers;

import org.springframework.boot.autoconfigure.web.client.HttpMessageConvertersRestClientCustomizer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitmanager.system.application.command.StudentCommandService;
import com.fitmanager.system.application.command.records.CreateGoalCommand;
import com.fitmanager.system.application.command.records.CreateStudentCommand;
import com.fitmanager.system.application.command.records.DeleteGoalCommand;
import com.fitmanager.system.application.command.records.DeleteStudentCommand;

import jakarta.validation.Valid;

@RestController
@RequestMapping("student")
public class StudentCommandController {

	private final StudentCommandService studentCommandService;

	public StudentCommandController(final StudentCommandService studentCommandService) {
		this.studentCommandService = studentCommandService;
	}

	@PostMapping
	public ResponseEntity<String> register(@Valid @RequestBody CreateStudentCommand payload) {
		var studentId = studentCommandService.register(payload);
		return ResponseEntity.status(HttpStatus.CREATED).body(studentId);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> unregister(@Valid @PathVariable String id) {
		var deletionCommand = new DeleteStudentCommand(id);
		studentCommandService.unregister(deletionCommand);
		return ResponseEntity.status(HttpStatus.OK).body(id);
	}

	@PostMapping("/{studentId}/goals")
	public ResponseEntity<String> addGoal(@Valid @PathVariable String studentId,
			@Valid @RequestBody CreateGoalCommand goalPayload) {
		studentCommandService.addGoalToStudent(studentId, goalPayload);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@DeleteMapping("/{studentId}/goals/{goalId}")
	public ResponseEntity<String> removeGoal(@Valid @PathVariable String studentId, @Valid @PathVariable String goalId) {
		DeleteGoalCommand deletionCommand = new DeleteGoalCommand(goalId);
		studentCommandService.removeGoalFromStudent(studentId, deletionCommand);

		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
