package org.example;

import java.util.LinkedList;

public class RecursiveLesson {

    public static long exponentiation(int number, int degree) {
        if (degree == 0) {
            return 1;
        }

        return number * exponentiation(number, degree - 1);
    }

    public static int calculateDigitsSum(int number) {
        if (number < 10) {
            return number;
        }

        StringBuilder builder = new StringBuilder(String.valueOf(number));

        return Integer.parseInt(builder.substring(0, 1)) + calculateDigitsSum(Integer.parseInt(builder.deleteCharAt(0).toString()));
    }

    public static int getListLength(LinkedList<?> list) {
        try {
            list.pop();
        } catch (Throwable th) {
            return 0;
        }

        return 1 + getListLength(list);
    }
}
