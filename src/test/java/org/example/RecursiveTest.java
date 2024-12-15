package org.example;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.RecursiveLesson.*;

public class RecursiveTest {

    @Test
    void exponentiationTest() {
        long result = exponentiation(2, 4);

        assertThat(result).isEqualTo(16);
    }

    @Test
    void calculateDigitsSumTest() {
        int result = calculateDigitsSum(123450);

        assertThat(result).isEqualTo(15);
    }

    @Test
    void getListLengthTest() {
        int result = getListLength(new LinkedList<>(Arrays.asList(1,2,3,4,5)));

        assertThat(result).isEqualTo(5);
    }

    @Test
    void isPalindromeTest() {
        boolean result = isPalindrome("abba");

        assertThat(result).isTrue();
    }

    @Test
    void findEvenNumbersTest() {
        findEvenNumbers(new LinkedList<>(Arrays.asList(1,2,3,4,5,6,7,8)));
    }

    @Test
    void findNumbersWithEvenIndexTest() {
        findEvenIndex(new LinkedList<>(Arrays.asList(1,2,3,4,5,6,7,8)));
    }

    @Test
    void findSecondMaxValueTest() {
        int res = findSecondMaxValue(Arrays.asList(790,2,3,790,95,17,8,54));

        assertThat(res).isEqualTo(790);
    }

    @Test
    void findAllFilesInDirectoryTest() throws Exception{
        List<Path> result = findAllFilesInDirectory("/Users/igooorrrrr/Desktop/пробное");
    }
}
