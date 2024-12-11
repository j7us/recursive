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

        return (number % 10) + calculateDigitsSum(number/10);
    }

    public static int getListLength(LinkedList<?> list) {
        try {
            list.pop();
        } catch (Throwable th) {
            return 0;
        }

        return 1 + getListLength(list);
    }

    public static boolean isPalindrome(String palindromeTest) {
        if (palindromeTest.length() == 1 || palindromeTest.isEmpty()) {
            return true;
        }

        StringBuilder builder = new StringBuilder(palindromeTest);

        boolean isPalindromeOnThisStep = builder.charAt(0) == builder.charAt(builder.length() - 1);

        return isPalindromeOnThisStep && isPalindrome(builder.substring(1, builder.length()-1));
    }

    public static String findEvenNumbers(LinkedList<Integer> numbers) {
        if (numbers.isEmpty()) {
            return "";
        }

        Integer currentNumber = numbers.removeFirst();

        String stepResult = currentNumber % 2 == 0 ? String.valueOf(currentNumber) : "";

        return stepResult + findEvenNumbers(numbers);
    }

    public static String findEvenIndex(LinkedList<?> numbers) {
        return findEvenIndexRecursive(numbers, 0);
    }

    private static String findEvenIndexRecursive(LinkedList<?> numbers, int index) {
        if (index == numbers.size()) {
            return "";
        }

        String stepResult = index % 2 == 0 ? numbers.get(index).toString() : "";

        return stepResult + findEvenIndexRecursive(numbers, ++index);
    }
}
