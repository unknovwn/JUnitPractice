package com.example.email;

import java.util.regex.Pattern;

public class EmailValidator {

    public static final Pattern EMAIL_PATTERN = Pattern.compile(
            "[\\w+.%\\-]{1,256}@\\w[\\w\\-]{0,64}(\\.\\w[\\w\\-]{0,25})+"
    );

    /**
     * Validates if the given input is a valid email address
     *
     * @param email The email to validate
     * @return {@code true} if the input is a valid email. {@code false} otherwise
     */
    public static boolean isValidEmail(CharSequence email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }
}
