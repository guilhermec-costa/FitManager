package com.fitmanager.system.application.command;

import org.springframework.stereotype.Service;

import com.fitmanager.system.application.abstractions.BaseCommandService;
import com.fitmanager.system.application.abstractions.ICommand;
import com.fitmanager.system.application.command.records.CreateGoalCommand;
import com.fitmanager.system.application.command.records.CreateStudentCommand;
import com.fitmanager.system.application.command.records.DeleteStudentCommand;
import com.fitmanager.system.domain.Goal.Goal;
import com.fitmanager.system.domain.Student.Student;
import com.fitmanager.system.infra.repositories.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentCommandService implements BaseCommandService<Student, String> {

    private final StudentRepository studentRepository;

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
    public String register(ICommand command) {
        var creationCommand = (CreateStudentCommand) command;
        Student student = Student.create(creationCommand.name(), creationCommand.email(), creationCommand.phone(), creationCommand.birthDate());
        Student savedUser = studentRepository.save(student);
        return savedUser.getId();
    }

    @Override
    public void unregister(ICommand command) {
        var deletionCommand = (DeleteStudentCommand)command;
        boolean userExist = studentRepository.existsById(deletionCommand.id());
        if(!userExist) throw new RuntimeException("User does not exist");

        studentRepository.deleteById(deletionCommand.id());
    }
}
