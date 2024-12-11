package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

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
        boolean result = isPalindrome("abbcbba");

        assertThat(result).isTrue();
    }

    @Test
    void findEvenNumbersTest() {
        String result = findEvenNumbers(new LinkedList<>(Arrays.asList(1,2,3,4,5,6,7,8)));

        assertThat(result).isEqualTo("2468");
    }

    @Test
    void findNumbersWithEvenIndexTest() {
        String result = findEvenIndex(new LinkedList<>(Arrays.asList(1,2,3,4,5,6,7,8)));

        assertThat(result).isEqualTo("1357");
    }
}
