package com.fitmanager.system.domain.Student;

import java.time.LocalDateTime;
import java.util.List;

import com.fitmanager.system.domain.BaseEntity;
import com.fitmanager.system.domain.Diet.Diet;
import com.fitmanager.system.domain.Goal.Goal;
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
import lombok.Builder;

@Builder
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

    @OneToOne
    @JoinColumn(name = "diet_id")
    private Diet diet;
}
