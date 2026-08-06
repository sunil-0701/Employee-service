package com.example.employeeservice.util;

public final class CommonUtil {
    private CommonUtil() { }
    public static void checkPaginationParameters(int currentPage, int perPage) {
        if (currentPage < 1) throw new IllegalArgumentException("currentPage must be at least 1");
        if (perPage < 1 || perPage > 100) throw new IllegalArgumentException("perPage must be between 1 and 100");
    }
}
