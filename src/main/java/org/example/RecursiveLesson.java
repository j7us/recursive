package org.example;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
        return isPalindromeRecursive(palindromeTest, 0);
    }

    private static boolean isPalindromeRecursive(String palindromeTest, int index) {
        if (index == palindromeTest.length() - (1 + index) || index > palindromeTest.length() - (1 + index)) {
            return true;
        }

        if (palindromeTest.charAt(index) != palindromeTest.charAt(palindromeTest.length() - (1 + index))) {
            return false;
        }

        return isPalindromeRecursive(palindromeTest, ++index);
    }

    public static void findEvenNumbers(LinkedList<Integer> numbers) {
        findEvenNumbersRecursive(numbers, 0);
    }

    public static void findEvenNumbersRecursive(LinkedList<Integer> numbers, int index) {
        if (index == numbers.size()) {
            return;
        }

        if (numbers.get(index) % 2 == 0) {
            System.out.println(numbers.get(index));
        }

        findEvenNumbersRecursive(numbers, index + 1);
    }

    public static void findEvenIndex(LinkedList<?> numbers) {
        findEvenIndexRecursive(numbers, 0);
    }

    private static void findEvenIndexRecursive(LinkedList<?> numbers, int index) {
        if (index == numbers.size()) {
            return;
        }

        if (index % 2 == 0) {
            System.out.println(numbers.get(index));
        }

        findEvenIndexRecursive(numbers, ++index);
    }

    public static int findSecondMaxValue(List<Integer> numbers) {
        if (numbers.size() == 1) {
            return numbers.get(0);
        }

        Integer secondMaxValue;
        Integer maxValue;

        if (numbers.get(0) <= numbers.get(1)) {
            secondMaxValue = numbers.get(0);
            maxValue = numbers.get(1);
        } else {
            secondMaxValue = numbers.get(1);
            maxValue = numbers.get(0);
        }

        if (numbers.size() == 2) {
            return secondMaxValue;
        }

        return findSecondMaxValueRecursive(numbers,2, secondMaxValue, maxValue);
    }

    private static int findSecondMaxValueRecursive(List<Integer> numbers,
                                                   int index,
                                                   int secondMaxValue,
                                                   int maxValue) {
        if (index == numbers.size()) {
            return secondMaxValue;
        }

        Integer currentValue = numbers.get(index);

        if (currentValue >= maxValue) {
            return findSecondMaxValueRecursive(numbers, ++index, maxValue, currentValue);
        } else if (currentValue > secondMaxValue) {
            return findSecondMaxValueRecursive(numbers, ++index, currentValue, maxValue);
        }

        return findSecondMaxValueRecursive(numbers, ++index, secondMaxValue, maxValue);
    }

    public static List<Path> findAllFilesInDirectory(String path) throws Exception{
        Path path1 = Path.of(path);
        List<Path> resultList = new ArrayList<>();

        try (DirectoryStream<Path> paths = Files.newDirectoryStream(path1);){
            for (Path p : paths) {
                if (Files.isDirectory(p)) {
                    resultList.addAll(findAllFilesInDirectory(p.toString()));
                } else {
                    resultList.add(p);
                }
            }
        }

        return resultList;
    }

    public static ArrayList<String> generateParentheses(int count) {
        char[] resulStringConstructor = new char[count * 2];
        ArrayList<String> list = new ArrayList<>();
        generateParenthesesRecursive(list, count, count, resulStringConstructor, 0);
        return list;
    }

    public static void generateParenthesesRecursive(ArrayList<String> list, int leftPar, int rightPar, char[] resulStringConstructor, int count) {
        if (leftPar == 0 && rightPar == 0) {
            String s = String.copyValueOf(resulStringConstructor);
            list.add(s);
        } else {
            if (leftPar > 0) {
                resulStringConstructor[count] = '(';
                generateParenthesesRecursive(list, leftPar - 1, rightPar, resulStringConstructor, count + 1);
            }

            if (rightPar > leftPar) {
                resulStringConstructor[count] = ')';
                generateParenthesesRecursive(list, leftPar, rightPar - 1, resulStringConstructor, count + 1);
            }
        }
    }
}
