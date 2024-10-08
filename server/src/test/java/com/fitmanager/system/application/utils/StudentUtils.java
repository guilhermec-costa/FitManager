package com.fitmanager.system.application.utils;

import java.util.ArrayList;

import com.fitmanager.system.domain.Goal.Goal;
import com.fitmanager.system.domain.Student.Student;
import com.fitmanager.system.domain.VO.Email;
import com.github.javafaker.Faker;
import java.util.UUID;

public class StudentUtils {

    private static Faker faker;

    static {
        faker = new Faker();
    }

    public static Student generateStudent() {
        final var fakeEmail = faker.internet().emailAddress();
        final var fakeId = UUID.randomUUID().toString();

        Student student = Student.builder()
                .id(fakeId)
                // .user(new User("guilherme", "costa", "password", new Email(fakeEmail), new Phone(fakePhone)))
                .email(new Email(fakeEmail))
                .goals(new ArrayList<Goal>())
                .build();

        return student;
    }
}
