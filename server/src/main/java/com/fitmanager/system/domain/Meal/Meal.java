package com.fitmanager.system.domain.Meal;


import com.fitmanager.system.domain.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
}
