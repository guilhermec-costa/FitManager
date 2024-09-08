package com.fitmanager.system.application.mappers;

import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fitmanager.system.application.presentation.StudentDTO;
import com.fitmanager.system.domain.Student.Student;

@Component
public class StudentMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public StudentMapper(final ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public StudentDTO StudentToDTO(Student student) {
        StudentDTO studentDTO = modelMapper.map(student, StudentDTO.class);
        return studentDTO;
    };

    public Student DTOToStudent(StudentDTO studentDTO) {
        Student student = modelMapper.map(studentDTO, Student.class);
        return student;
    }
}
