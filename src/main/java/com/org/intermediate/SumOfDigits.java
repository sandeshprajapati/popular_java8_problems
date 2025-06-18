package com.org.intermediate;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class SumOfDigits {
    public static void main(String[] args) {
        int [] arr ={123,432,607,324,625};

        int[] result = Arrays.stream(arr)
                .map(num -> String.valueOf(num) // Convert number to string
                        .chars() // Get stream of characters
                        .map(Character::getNumericValue) // Convert each character to its numeric value
                        .reduce(0, Integer::sum)) // Use reduce to sum digits
                .toArray(); // Collect the results back into an array
    }
}
