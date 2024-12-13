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

        boolean isPalindromeOnCurrentStep = palindromeTest.charAt(index) == palindromeTest.charAt(palindromeTest.length() - (1 + index));

        return isPalindromeOnCurrentStep && isPalindromeRecursive(palindromeTest, ++index);
    }

    public static void findEvenNumbers(LinkedList<Integer> numbers) {
        if (numbers.isEmpty()) {
            return;
        }

        Integer currentNumber = numbers.removeFirst();

        if (currentNumber % 2 == 0) {
            System.out.println(currentNumber);
        }

        findEvenNumbers(numbers);
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
        return findSecondMaxValueRecursive(numbers,1, numbers.get(0), numbers.get(0));
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

    public static void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int count) {
        if (leftRem == 0 && rightRem == 0) {
            String s = String.copyValueOf(str);
            list.add(s);
        } else {
            if (leftRem > 0) {
                str[count] = '(';
                addParen(list, leftRem - 1, rightRem, str, count + 1);
            }

            if (rightRem > leftRem) {
                str[count] = ')';
                addParen(list, leftRem, rightRem - 1, str, count + 1);
            }
        }
    }
    public static ArrayList<String> generateParens(int count) {
        char[] str = new char[count * 2];
        ArrayList<String> list = new ArrayList<String>();
        addParen(list, count, count, str, 0);
        return list;
    }
}
