package com.fitmanager.system.domain.Student;

import com.fitmanager.system.domain.BaseEntity;
import com.fitmanager.system.domain.VO.Email;
import com.fitmanager.system.domain.VO.converters.EmailAttributeConverter;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Student extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = EmailAttributeConverter.class)
    private Email email;
}
