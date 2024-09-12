package com.fitmanager.system.application.command.records;

import com.fitmanager.system.application.abstractions.ICommand;

public record DeleteGoalCommand(String id) implements ICommand {
}
