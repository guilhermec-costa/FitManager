package com.fitmanager.system.domain.VO;

import java.util.regex.Pattern;

import com.fitmanager.system.domain.ValueObject;

import java.util.regex.Matcher;

public record Email(String email) implements ValueObject {
    private static Pattern EMAIL_PATTERN;
    private static String EMAIL_VALIDATION_REGEX;
    private static short MAXIMUM_EMAIL_LENGTH;

    public Email(String email) {
        if (email == null || !isValid(email)) {
            throw new IllegalArgumentException("Invalid email pattern");
        }
        this.email = email;
    }

    static {
        EMAIL_VALIDATION_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        EMAIL_PATTERN = Pattern.compile(EMAIL_VALIDATION_REGEX);
        MAXIMUM_EMAIL_LENGTH = 50;
    }

    private static boolean isValid(String againstValue) {
        final Matcher _matcher = EMAIL_PATTERN.matcher(againstValue);
        final boolean isConditionSatisfied = _matcher.find() && !exceedsMaximumLength(againstValue);
        return isConditionSatisfied;
    }

    private static boolean exceedsMaximumLength(String email) {
        return email.length() > MAXIMUM_EMAIL_LENGTH;
    }

    public String unwrap() {
        return email;
    }
}
