package com.fitmanager.system.application.command.records;

import java.time.LocalDateTime;

import com.fitmanager.system.application.abstractions.ICommand;

public record CreateStudentCommand(String name, String email, String phone, LocalDateTime birthDate) implements ICommand {
}
