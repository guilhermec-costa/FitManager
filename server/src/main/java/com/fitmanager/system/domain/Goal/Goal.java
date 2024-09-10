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
import lombok.Setter;
import lombok.AccessLevel;

import java.time.LocalDateTime;

import com.fitmanager.system.domain.BaseEntity;
import com.fitmanager.system.domain.Goal.exceptions.GoalAlreadyCompletedException;
import com.fitmanager.system.domain.Student.Student;


@Data
@Builder
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Goal extends BaseEntity {

    final static int MAXIMUM_GOAL_PROGRESS; 
    static {
        MAXIMUM_GOAL_PROGRESS = 100;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    @Column
    private String description;
    
    @Column(nullable = false)
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

    public Goal(String description, LocalDateTime startDate) {
        this.description = description;
        this.startDate = startDate;
    }

    public Goal(String description, LocalDateTime startDate, LocalDateTime endDate) {
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    private boolean isCompleted() {
        final var _isCompleted = (progress == MAXIMUM_GOAL_PROGRESS) && (status == GoalStatus.COMPLETED);
        return _isCompleted;
    }
    
    private boolean isGoalDateRangeValid() {
        final boolean startDateIsBeforeEndDate = startDate.isBefore(endDate);
        return startDateIsBeforeEndDate || (startDateIsBeforeEndDate && endDate == null);
    }
    
    private boolean hasStudentAssociated() {
        return this.student != null;
    }
    
    public boolean canBeAssociated() {
        return 
            !isCompleted() && 
            isGoalDateRangeValid() && 
            !hasStudentAssociated();
    }

    public void completeGoal() {
        if(isCompleted()) throw new GoalAlreadyCompletedException("Goal is already completed");
        status = GoalStatus.COMPLETED;
        progress = MAXIMUM_GOAL_PROGRESS;
    }

    public void associate(final Student student) {
        this.student = student;
    }

    public void dissociate() {
        this.student = null;
    }
}
