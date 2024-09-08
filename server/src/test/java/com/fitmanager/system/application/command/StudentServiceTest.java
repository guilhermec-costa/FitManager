package com.fitmanager.system.application.command;

import com.fitmanager.system.application.utils.StudentUtils;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fitmanager.system.domain.Goal.Goal;
import com.fitmanager.system.domain.Goal.GoalRepository;
import com.fitmanager.system.domain.Student.Student;
import com.fitmanager.system.domain.Student.StudentRepository;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock private StudentRepository studentRepository;
    @Mock private GoalRepository goalRepository;

    private StudentService studentService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        studentService = new StudentService(studentRepository);
    }

    @Test
    @DisplayName("Should associate a goal to a student")
    void shouldAddGoalToStudent() {
        Student generatedStudent = StudentUtils.generateStudent();
        Goal goal = new Goal("A simple goal", LocalDateTime.now());

        when(studentRepository.findById(anyString())).thenReturn(Optional.of(generatedStudent));
        when(studentRepository.save(any(Student.class))).thenReturn(generatedStudent);

        studentService.addGoalToStudent(generatedStudent.getId(), goal);

        verify(studentRepository, times(1)).findById(generatedStudent.getId());
        verify(studentRepository).save(generatedStudent);

        assertTrue(generatedStudent.getGoals().contains(goal));
    }

    @Test
    @DisplayName("Should throw exception on add goal to a student")
    void shouldThrownOnAddGoalToStudent() {
        Student generatedStudent = Mockito.mock(Student.class);
        Goal goal = new Goal("A simple goal", LocalDateTime.now());

        assertThatThrownBy(() -> studentService.addGoalToStudent(generatedStudent.getId(), goal))
            .isInstanceOf(RuntimeException.class).hasMessageContaining("Student not found");

        verify(generatedStudent, never()).associateGoal(goal);
        verify(studentRepository, never()).save(generatedStudent);
    }
}
