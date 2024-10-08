package com.fitmanager.system.domain.Student;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

import jakarta.persistence.CascadeType;
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
import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@Entity
@Table
public class Student extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    private String name;

    @Convert(converter = EmailAttributeConverter.class)
    @Column(unique = true, nullable = false, length = 50)
    private Email email;

    @Convert(converter = PhoneAttributeConverter.class)
    @Column(unique = true, nullable = false)
    private Phone phone;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate = LocalDateTime.now();

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Goal> goals = new ArrayList<>();

    @OneToMany(mappedBy = "student")
    private List<BodyMeasurement> bodyMeasurements;

    @OneToMany(mappedBy = "student")
    private List<Training> trainings;

    @OneToOne
    @JoinColumn(name = "diet_id")
    private Diet diet;

    @SuppressWarnings("unused")
    private Student() {
    };

    public static Student create(String name, String email, String phone) {
        return new Student(name, email, phone);
    }

    public static Student create(String name, String email, String phone, LocalDateTime birthDate) {
        return new Student(name, email, phone, birthDate);
    }

    public Student(String name, String email, String phone) {
        this.name = name;
        this.email = new Email(email);
        this.phone = new Phone(phone);
    };

    public Student(String name, String email, String phone, LocalDateTime birthDate) {
        this.name = name;
        this.email = new Email(email);
        this.phone = new Phone(phone);
        this.birthDate = birthDate;
        this.registrationDate = LocalDateTime.now();
    }

    public void associateGoal(Goal goal) {
        if (!goal.canBeAssociated())
            throw new RuntimeException("Not possible to add goal");

        goal.associate(this);
        goals.add(goal);
    }

    public void dissociateGoal(Goal goal) {
        goal.dissociate();
        goals.remove(goal);
    }
}
