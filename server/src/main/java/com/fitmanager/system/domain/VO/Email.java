package com.fitmanager.system.domain.VO;

import lombok.Getter;
import java.util.regex.Pattern;

import com.fitmanager.system.domain.BaseValueObject;

import java.util.regex.Matcher;

@Getter
public class Email implements BaseValueObject {
    private String value;
    private static Pattern EMAIL_PATTERN;
    private static final String EMAIL_VALIDATION_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    public Email(String email) {
        if (value == null || !isValid(email)) {
            throw new IllegalArgumentException("Invalid email pattern");
        }
        value = email;
    }

    static {
        EMAIL_PATTERN = Pattern.compile(EMAIL_VALIDATION_REGEX);
    }

    private static boolean isValid(String againstValue) {
        final Matcher _matcher = EMAIL_PATTERN.matcher(againstValue);
        return _matcher.find();
    }

    public String unwrap() {
        return value;
    }
}
