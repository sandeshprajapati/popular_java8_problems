package com.org.advance;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class AdvancedJava8Problems {
    public static void main(String[] args) {
        System.out.println("Group a list of strings by their length");
        groupByLenOfString();
        System.out.println("Partition a list of integers into even and odd");
        partitionByEvenAndOddNumber();
        System.out.println("Count the occurrences of each word in a sentence");
        countTheOccurrencesOfEachWord();
        System.out.println("Find the longest string in a list");
        findTheLongestStringInList();
        System.out.println("Find the shortest string in a list");
        findTheShortestStringInList();
        System.out.println("Join a list of strings with a delimiter");
        joinListOfStrings();
        System.out.println("Convert a list of strings to a single concatenated string");
        convertListOfStringToOneWord();
        System.out.println("Filter strings that match a given regular expression");
        matchStringWithRegx();
        System.out.println("Remove null values from a list");
        removeNullValuefromList();
        System.out.println("Skip the first n elements in a list");
        skipNthEleFromList();

    }

    private static void skipNthEleFromList() {
        List<Integer> list = Arrays.asList(4, 5, 1, 5, 2, 1, 7, 10, 3, 6);
        final List<Integer> list1 = list.stream().skip(3).collect(Collectors.toList());
        System.out.println(list1);

    }

    private static void removeNullValuefromList() {
        List<String> words = Arrays.asList("cat", "dog", null, "bat", null);
        final List<String> list = words.stream().filter(Objects::nonNull).collect(Collectors.toList());
        System.out.println(list);
    }

    private static void matchStringWithRegx() {
        List<String> words = Arrays.asList("cat", "dog", "car", "bat", "cap");
        String regex = "c.*";
        List<String> filtered = words.stream()
                .filter(Pattern.compile(regex).asPredicate())
                .collect(Collectors.toList());

        System.out.println("Filtered words: " + filtered);
    }

    private static void convertListOfStringToOneWord() {
        List<String> words = Arrays.asList("Java", "is", "awesome");
        final String s = words.stream().collect(Collectors.joining());
        System.out.println(s);
    }

    private static void joinListOfStrings() {
        List<String> list = Arrays.asList("Ram", "Mohan", "Gaurav", "Sandy");
        final String s = list.stream().collect(Collectors.joining(","));
        System.out.println(s);
    }

    private static void findTheShortestStringInList() {
        List<String> list = Arrays.asList("Ram", "Mohan", "Gaurav", "Sandy");
        final String s = list.stream().min((s1, s2) -> Integer.compare(s1.length(), s2.length())).orElse("");
        System.out.println(s);
    }

    private static void findTheLongestStringInList() {
        List<String> list = Arrays.asList("Ram", "Mohan", "Gaurav", "Sandy");
        final String s = list.stream().max((s1, s2) -> Integer.compare(s1.length(), s2.length())).orElse("");
        System.out.println(s);
    }

    private static void countTheOccurrencesOfEachWord() {
        String sentence = "Java is great and Java is powerful";
        final Map<String, Long> map = Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
    }

    private static void partitionByEvenAndOddNumber() {
        List<Integer> list = Arrays.asList(4, 5, 1, 5, 2, 1, 7, 10, 3, 6);
        final Map<Boolean, List<Integer>> map = list.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(map);
    }

    private static void groupByLenOfString() {
        List<String> list = Arrays.asList("Ram", "Mohan", "Gaurav", "Sandy");
        final Map<Integer, List<String>> map = list.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(map);
    }
}
