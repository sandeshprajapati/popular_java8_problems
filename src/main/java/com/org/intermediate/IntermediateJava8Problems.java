package com.org.intermediate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateJava8Problems {
    public static void main(String[] args) {
        System.out.println("Find the maximum value in a list");
        maxValueInList();
        System.out.println("Find the minimum value in a list");
        minValueInList();
        System.out.println("Calculate the average of numbers in a list");
        avgValueInList();
        System.out.println("Sum all elements in a list");
        sumOfAllEle();
        System.out.println("Count the number of elements in a list");
        countTheNumberInList();
        System.out.println("Find the second highest number in a list");
        sencodHighestNumberInList();
        System.out.println("Find the second lowest number in a list");
        sencodlLowestNumberInList();
        System.out.println("Merge two lists into one");
        mergeTwoList();
        System.out.println("Find common elements between two lists");
        findCommonInList();
    }

    private static void findCommonInList() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 6);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        final List<Integer> list = list2.stream().filter(list1::contains).collect(Collectors.toList());
        System.out.println(list);


    }

    private static void mergeTwoList() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        final List<Integer> list = Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
        System.out.println(list);

    }

    private static void sencodlLowestNumberInList() {
        List<Integer> list = Arrays.asList(4, 5, 1, 5, 2, 1, 7, 10, 3, 6);
        final List<Integer> list1 = list.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        System.out.println(list1);
        final Integer i = list.stream().sorted(Comparator.naturalOrder()).distinct().skip(1).findFirst().orElse(0);
        System.out.println(i);

        final Integer i1 = list.stream().sorted((o1, o2) -> o1 - o2).distinct().skip(1).findFirst().orElse(0);
        System.out.println(i1);

    }

    private static void sencodHighestNumberInList() {
        List<Integer> list = Arrays.asList(4, 5, 1, 5, 7, 10, 3);
        final List<Integer> list1 = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(list1);
        final Integer i = list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0);
        System.out.println(i);
    }

    private static void countTheNumberInList() {
        List<Integer> list = Arrays.asList(4, 5, 1, 5, 7, 10, 3);
        final long count = list.stream().count();
        System.out.println(count);

    }

    private static void sumOfAllEle() {
        List<Integer> list = Arrays.asList(4, 5, 1, 5, 7, 10, 3);
        final int sum = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }

    private static void avgValueInList() {
        List<Integer> list = Arrays.asList(4, 5, 1, 5, 7, 10, 3);
        final Double avg = list.stream().collect(Collectors.averagingInt(value -> value));
        System.out.println(avg);
        System.out.println("2nd way");
        final double avg1 = list.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println(avg1);
    }

    private static void minValueInList() {
        List<Integer> list = Arrays.asList(4, 5, 1, 5, 7, 10, 3);
        final Integer max = list.stream().min(Integer::compare).orElse(0);
        System.out.println(max);
    }

    private static void maxValueInList() {
        List<Integer> list = Arrays.asList(4, 5, 1, 5, 7, 10, 3);
        final Integer max = list.stream().max(Integer::compareTo).orElse(0);
        System.out.println(max);
    }
}
