package com.fitmanager.system.infra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fitmanager.system.domain.Student.Student;
import com.fitmanager.system.domain.VO.Email;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    Optional<Student> findByEmail(Email email);
}
