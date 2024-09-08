package com.fitmanager.system.application.command.records;

import com.fitmanager.system.application.abstractions.ICommand;
import java.time.LocalDateTime;

public record CreateGoalCommand(String description, LocalDateTime startDate) implements ICommand {
}
