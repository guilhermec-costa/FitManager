package com.fitmanager.system.application.command.records;

import com.fitmanager.system.application.abstractions.ICommand;

public record DeleteStudentCommand(String id) implements ICommand {}
