package com.fitmanager.system.application.command.records;

import java.time.LocalDateTime;

import com.fitmanager.system.application.abstractions.ICommand;

import jakarta.validation.constraints.NotNull;

public record CreateStudentCommand(
	@NotNull(message = "Name is required") String name, 
	@NotNull String email, 
	@NotNull String phone, 
	@NotNull LocalDateTime birthDate) implements ICommand {

}
