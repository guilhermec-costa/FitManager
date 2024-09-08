package com.fitmanager.system.application.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitmanager.system.application.abstractions.BaseCommandService;
import com.fitmanager.system.application.abstractions.ICommand;
import com.fitmanager.system.application.command.records.CreateGoalCommand;
import com.fitmanager.system.application.command.records.CreateStudentCommand;
import com.fitmanager.system.domain.Goal.Goal;
import com.fitmanager.system.domain.Student.Student;
import com.fitmanager.system.infra.repositories.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentCommandService implements BaseCommandService<Student> {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentCommandService(final StudentRepository _studentRepository) {
        studentRepository = _studentRepository;
    }

    @Transactional
    public void addGoalToStudent(final String studentId, final CreateGoalCommand goalCommand) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Goal goal = new Goal(goalCommand.description(), goalCommand.startDate());
        student.associateGoal(goal);

        studentRepository.save(student);
    }

    @Override
    public void register(ICommand command) {
        var creationCommand = (CreateStudentCommand) command;
        Student student = new Student(creationCommand.name(), creationCommand.email(), creationCommand.phone());
        studentRepository.save(student);
    }
}
