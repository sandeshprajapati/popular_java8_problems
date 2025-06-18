package com.org.basic;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        final List<String> list = Arrays.asList("GFG", "Rahul", "Image", "Employee", "EmployeeDocuments");
        final OptionalInt max = list.stream().mapToInt(String::length).max();
        final Optional<String> max1 = list.stream().max(Comparator.comparing(String::length));
        System.out.println(max1.get());

    }
}
