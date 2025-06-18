package com.org.basic;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BasicJava8Problems {

    public static void main(String[] args) {
        //Filter even numbers from a list.
        System.out.println("Filter even numbers from a list.");
        findEvenNumbers();
        //Find numbers starting with a specific digit.
        System.out.println("Find numbers starting with a specific digit");
        findStartWithNumbers();
        System.out.println("Remove duplicate elements from a list.");
        removeDuplicateFromList();
        System.out.println("Count the frequency of each element in a list");
        countFeqofList();
        System.out.println("Find the first non-repeated character in a string.");
        findNonRepCharInString();
        System.out.println("Find the first repeated character in a string");
        findFirstRepCharInString();
        System.out.println("Sort a list of strings alphabetically");
        sortListaAlphabetically();
        System.out.println("Sort a list of integers in descending order");
        sortIntListDESC();
        System.out.println("Convert a list of strings to uppercase");
        listStrInUpperCase();
        System.out.println("print duplicate element from array");
        printDuplicateElementFromArray();
    }

    private static void printDuplicateElementFromArray() {
        List<Integer> list = Arrays.asList(4, 5, 1, 5, 7, 10, 3,4);
        final List<Integer> list1 = list
                .stream()
                .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(map -> map.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(list1);
    }

    private static void listStrInUpperCase() {
        List<String> list = Arrays.asList("Ram", "Mohan", "Gaurav", "Sandy");
        final List<String> list1 = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(list1);
    }

    private static void sortIntListDESC() {
        List<Integer> list = Arrays.asList(4, 5, 1, 5, 7, 10, 3);
        final List<Integer> list1 = list.stream().sorted(((o1, o2) -> o2.compareTo(o1))).collect(Collectors.toList());
        System.out.println(list1);
    }

    private static void sortListaAlphabetically() {
        List<String> list = Arrays.asList("Ram", "Mohan", "Gaurav", "Sandy");
        final List<String> list1 = list.stream().sorted().collect(Collectors.toList());
        System.out.println(list1);
    }

    private static void findFirstRepCharInString() {
        String s = "shwsyhwhahautwm";

        final Map.Entry<Character, Long> entryList =
                s.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                        .entrySet()
                        .stream()
                        .filter(e -> e.getValue() > 1)
                        .findFirst()
                        .orElse(null);
        System.out.println(entryList);
        System.out.println("2nd approach");
        Set<Character> seen = new HashSet<>();
        final Character c1 =
                s.chars()
                        .mapToObj(c -> (char) c)
                        .filter(c -> !seen.add(c)).findFirst()
                        .orElse(null);
        System.out.println(c1);
    }


    private static void findNonRepCharInString() {
        String s = "shwsyhwhahautwm";
        final Map<Character, Long> feqMap =
                s.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println(feqMap);
        final List<Map.Entry<Character, Long>> entryList =
                s.chars().mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet()
                        .stream()
                        .filter(e -> e.getValue() == 1)
                        .collect(Collectors.toList());
        System.out.println(entryList);
    }

    private static void countFeqofList() {
        List<Integer> nums = Arrays.asList(2, 4, 2, 1, 4, 2, 1, 6);

        final Map<Integer, Long> feqMap = nums
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(feqMap);
    }

    private static void removeDuplicateFromList() {
        List<Integer> nums = Arrays.asList(2, 4, 2, 1, 4, 2, 1, 6);
        final List<Integer> distinct = nums.stream().distinct().collect(Collectors.toList());
        System.out.println(distinct);
    }

    private static void findStartWithNumbers() {
        int sw = 5;
        int num = 5043;
        final int swNumbers = IntStream.iterate(num, n -> n / 10).filter(n -> n < 10).findFirst().orElse(num);
        System.out.println(swNumbers);
    }

    private static void findEvenNumbers() {
        List<Integer> numbers = IntStream.rangeClosed(1, 20).boxed().collect(Collectors.toList());
        final List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println(evenNumbers);
    }
}
