package com.fitmanager.system.domain.Exercise;

import java.util.List;

import com.fitmanager.system.domain.BaseEntity;
import com.fitmanager.system.domain.Training.Training;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Exercise extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private int sets;

    @Column
    private int repetions;

    @Column
    private int restTime;

    @ManyToMany
    @JoinTable(
        name = "training_exercise",
        joinColumns = { @JoinColumn(name = "exercise_id") },
        inverseJoinColumns = { @JoinColumn(name = "training_id")}
    )
    private List<Training> trainings;
}
