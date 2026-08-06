package com.example.employeeservice.util;

public final class NameUtils {
    private NameUtils() { }
    public static String fullName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }
}
