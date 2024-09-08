package com.fitmanager.system.domain.Student;

import java.time.LocalDateTime;
import java.util.List;

import com.fitmanager.system.domain.BaseEntity;
import com.fitmanager.system.domain.BodyMeasurement.BodyMeasurement;
import com.fitmanager.system.domain.Diet.Diet;
import com.fitmanager.system.domain.Goal.Goal;
import com.fitmanager.system.domain.Training.Training;
import com.fitmanager.system.domain.VO.Email;
import com.fitmanager.system.domain.VO.Phone;
import com.fitmanager.system.domain.VO.converters.EmailAttributeConverter;
import com.fitmanager.system.domain.VO.converters.PhoneAttributeConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table
public class Student extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Convert(converter = EmailAttributeConverter.class)
    @Column(unique = true, nullable = false, length = 50)
    private Email email;

    @Convert(converter = PhoneAttributeConverter.class)
    @Column(unique = true, nullable = false)
    private Phone phone;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @OneToMany(mappedBy = "student")
    private List<Goal> goals;

    @OneToMany(mappedBy = "student")
    private List<BodyMeasurement> bodyMeasurements;

    @OneToMany(mappedBy = "student")
    private List<Training> trainings;

    @OneToOne
    @JoinColumn(name = "diet_id")
    private Diet diet;

    public void associateGoal(Goal goal) {
        goal.setStudent(this);
        goals.add(goal);
    }

    public void dissociateGoal(Goal goal) {
        goals.remove(goal);
        goal.setStudent(null);
    }

    

}
