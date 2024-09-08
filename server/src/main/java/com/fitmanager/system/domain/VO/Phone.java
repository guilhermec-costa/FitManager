package com.fitmanager.system.domain.VO;


import java.util.regex.Pattern;

import java.util.regex.Matcher;

import com.fitmanager.system.domain.ValueObject;

public class Phone implements ValueObject {
    private static Pattern PHONE_PATTERN;
    private static String PHONE_VALIDATION_REGEX;

    private final String phone;

    static {
        PHONE_VALIDATION_REGEX = "";
        PHONE_PATTERN = Pattern.compile(PHONE_VALIDATION_REGEX);
    }

    public Phone(String phone) {
        if(phone == null || !isValid(phone)) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phone = phone;
    }

    private static boolean isValid(String value) {
        final Matcher _matcher = PHONE_PATTERN.matcher(PHONE_VALIDATION_REGEX); 
        return _matcher.find();
    }

    public String unwrap() {
        return phone;
    }
}
