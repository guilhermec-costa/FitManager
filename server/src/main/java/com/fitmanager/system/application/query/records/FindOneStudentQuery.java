package com.fitmanager.system.application.query.records;

import com.fitmanager.system.application.abstractions.IQuery;

public record FindOneStudentQuery(String id) implements IQuery {
}
