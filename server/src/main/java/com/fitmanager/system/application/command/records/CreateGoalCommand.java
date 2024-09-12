package com.fitmanager.system.application.command.records;

import com.fitmanager.system.application.abstractions.ICommand;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CreateGoalCommand(
        @NotBlank String description,
        @NotNull(message = "Start date is required") LocalDateTime startDate,
        @NotNull(message = "End date is required") LocalDateTime endDate) implements ICommand {
}
