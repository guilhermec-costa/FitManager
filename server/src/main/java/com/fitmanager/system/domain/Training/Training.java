package com.fitmanager.system.domain.Training;

import java.util.List;

import com.fitmanager.system.domain.BaseEntity;
import com.fitmanager.system.domain.Exercise.Exercise;
import com.fitmanager.system.domain.Student.Student;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Training extends BaseEntity {
   
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    private String name;
    
    @Column
    private String description;

    @Column
    private int duration;

    @ManyToOne
    private Student student;

    @ManyToMany(mappedBy = "trainings")
    private List<Exercise> exercises;
}
