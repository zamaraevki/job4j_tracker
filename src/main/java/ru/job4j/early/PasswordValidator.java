package ru.job4j.early;

import static java.lang.Character.isDigit;
import static java.lang.Character.toLowerCase;

public class PasswordValidator {

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        boolean digit = false;
        boolean specialSymbol = false;
        boolean upperLatinLetter = false;
        boolean lowerLatinLetter = false;
        for (int i = 0; i < password.length(); i++) {
            int code = password.codePointAt(i);
            if (isDigit(code)) {
                digit = true;
            } else if (code >= 65 && code <= 95) {
                upperLatinLetter = true;
            } else if (code >= 97 && code <= 122) {
                lowerLatinLetter = true;
            } else {
                specialSymbol = true;
            }
        }
        if (!upperLatinLetter) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!lowerLatinLetter) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!specialSymbol) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        if (!digit) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (password.toLowerCase().indexOf("qwerty") != -1 || password.toLowerCase().indexOf("12345") != -1
                || password.toLowerCase().indexOf("password") != -1 || password.toLowerCase().indexOf("admin") != -1
                || password.toLowerCase().indexOf("user") != -1) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        return password;
    }
}
