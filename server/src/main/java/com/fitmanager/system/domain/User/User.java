package com.fitmanager.system.domain.User;

import com.fitmanager.system.domain.VO.Email;
import com.fitmanager.system.domain.VO.Phone;
import com.fitmanager.system.domain.VO.converters.EmailAttributeConverter;
import com.fitmanager.system.domain.VO.converters.PhoneAttributeConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Getter
@Setter(AccessLevel.PRIVATE)
@Embeddable
public class User {
   
    @Column
    private String firstname;

    @Column
    private String surname;

    @Column
    private String password;

    @Convert(converter = EmailAttributeConverter.class)
    @Column(unique = true, nullable = false, length = 50)
    private Email email;

    @Convert(converter = PhoneAttributeConverter.class)
    @Column(unique = true, nullable = false)
    private Phone phone;
}
