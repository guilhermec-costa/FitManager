package com.fitmanager.system.domain.Goal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import com.fitmanager.system.domain.BaseEntity;
import com.fitmanager.system.domain.Student.Student;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Goal extends BaseEntity {

    public Goal(String description, LocalDateTime startDate) {
        this.description = description;
        this.startDate = startDate;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    private String description;

    @Column
    @Enumerated(EnumType.STRING)
    private GoalStatus status;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column
    private double progress;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
