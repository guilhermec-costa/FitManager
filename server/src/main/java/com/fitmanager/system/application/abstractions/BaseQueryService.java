package com.fitmanager.system.application.abstractions;

import java.util.Optional;
import java.util.List;

public interface BaseQueryService<T> {

    <Q extends IQuery> Optional<T> findOne(Q query);
    List<T> findAll();
}