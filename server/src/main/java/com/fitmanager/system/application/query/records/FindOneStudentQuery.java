package com.fitmanager.system.application.query.records;

import com.fitmanager.system.application.abstractions.Query;

public record FindOneStudentQuery(String id) implements Query {
}
