package com.fitmanager.system.application.query;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitmanager.system.application.abstractions.BaseQueryService;
import com.fitmanager.system.application.abstractions.Query;
import com.fitmanager.system.application.query.records.FindOneStudentQuery;
import com.fitmanager.system.domain.Student.Student;
import com.fitmanager.system.infra.repositories.StudentRepository;

@Service
public class StudentQueryService implements BaseQueryService<Student> {
    private StudentRepository studentRepository;

    @Autowired
    public StudentQueryService(final StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        final var students = studentRepository.findAll();
        return students;
    }

    @Override
    public <Q extends Query> Optional<Student> findOne(Q query) {
        var convertedQuery = (FindOneStudentQuery)query;
        Optional<Student> student = studentRepository.findById(convertedQuery.id());
        return student;
    }
}
