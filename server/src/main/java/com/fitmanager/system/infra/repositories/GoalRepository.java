package com.fitmanager.system.infra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitmanager.system.domain.Goal.Goal;

public interface GoalRepository extends JpaRepository<Goal, String> {
}
