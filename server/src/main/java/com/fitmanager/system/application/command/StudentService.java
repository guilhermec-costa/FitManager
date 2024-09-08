package com.fitmanager.system.application.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitmanager.system.domain.Goal.Goal;
import com.fitmanager.system.domain.Student.Student;
import com.fitmanager.system.domain.Student.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(final StudentRepository _studentRepository) {
        studentRepository = _studentRepository;
    }

    @Transactional
    public void addGoalToStudent(String studentId, Goal goal) {
        Student student = studentRepository.findById(studentId)
            .orElseThrow(() -> new RuntimeException("Student not found"));

        student.associateGoal(goal);
        
        studentRepository.save(student);
    }
}
