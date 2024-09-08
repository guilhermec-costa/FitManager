package com.fitmanager.system.application.command.records;

import com.fitmanager.system.application.abstractions.ICommand;

public record CreateStudentCommand(String name, String email, String phone) implements ICommand {
}
