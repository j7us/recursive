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
}
