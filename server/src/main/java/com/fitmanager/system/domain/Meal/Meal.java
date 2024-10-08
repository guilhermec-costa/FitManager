package com.fitmanager.system.domain.Meal;


import java.util.List;

import com.fitmanager.system.domain.BaseEntity;
import com.fitmanager.system.domain.Diet.Diet;

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
public class Meal extends BaseEntity {
   
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    private int calories;

    @Column
    private double protein;

    @Column
    private double carbs;

    @Column
    private double fats;

    @ManyToMany
    @JoinTable(
        name = "meal_diet",
        joinColumns = { @JoinColumn(name = "meal_id") },
        inverseJoinColumns =  { @JoinColumn(name = "diet_id")}
    )
    private List<Diet> diets;
}
