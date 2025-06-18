package com.org.tougher;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EcommerceReport {
    public static void main(String[] args) {
        // Sample data setup
        LocalDate currentDate = LocalDate.now();

        // Create sample reviews
        Review review1 = new Review(5, currentDate.minusMonths(1)); // 1 month ago
        Review review2 = new Review(4, currentDate.minusMonths(2)); // 2 months ago
        Review review3 = new Review(3, currentDate.minusMonths(4)); // 4 months ago

        Review review4 = new Review(2, currentDate.minusMonths(7)); // 7 months ago
        Review review5 = new Review(5, currentDate.minusMonths(1)); // 1 month ago

        // Create sample products with reviews
        Product product1 = new Product("P1", "Product 1", 150, "Electronics", Arrays.asList(review1, review2, review3));
        Product product2 = new Product("P2", "Product 2", 250, "Furniture", Arrays.asList(review4, review5));
        Product product3 = new Product("P3", "Product 3", 300, "Electronics", Arrays.asList(review1, review2));
        Product product4 = new Product("P4", "Product 4", 100, "Clothing", Collections.singletonList(review3));
        Product product5 = new Product("P5", "Product 5", 120, "Furniture", Collections.singletonList(review1));
        Product product6 = new Product("P6", "Product 6", 140, "Furniture", Collections.singletonList(review4));
        List<Product> products = Arrays.asList(product1, product2, product3, product4, product5, product6);

        System.out.println("=====Best-selling product=====");
        // The product with the highest number of reviews in the last 3 months (or some specific time window).
        bestSellingProduct(products);
        System.out.println();
        System.out.println("===Average rating====");
        // Calculate the average rating for each product, but only for reviews that have been made in the last 6 months.
        avgRatingOfProduct(products);
        System.out.println();
        System.out.println("Top categories:");
        // List the top 3 categories with the highest average price per product, where the price is calculated as the average price of all products in that category.
        listOfTopCatWithHighestAvgPrice(products);
    }

    private static void listOfTopCatWithHighestAvgPrice(List<Product> products) {
        final Map<String, Double> p = products.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)));
        System.out.println(p);
        System.out.println();
        final List<Map.Entry<String, Double>> entries = products
                .stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingDouble(Map.Entry::getValue))
                .limit(3)
                .collect(Collectors.toList());
        entries.forEach(e->System.out.println(e.getKey()+"=="+e.getValue()));
    }

    private static void avgRatingOfProduct(List<Product> products) {
        LocalDate currentDate = LocalDate.now();
        LocalDate last6Months = currentDate.minusMonths(6);
        final Map<Product, Double> map = products
                .stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        p -> p.getReviews()
                                .stream()
                                .filter(r -> r.getTimestamp().isAfter(last6Months))
                                .mapToInt(Review::getRating).average().orElse(0)
                ));
        map.forEach((k, v) -> System.out.println(k.getName() + "=" + v));
    }

    private static void bestSellingProduct(List<Product> products) {
        LocalDate currentDate = LocalDate.now();
        LocalDate last3Months = currentDate.minusMonths(3);
        System.out.println("last3Months==" + last3Months);
        final Map<Product, Double> bestSellingProduct = products
                .stream()
                .collect(Collectors.toMap(Function.identity(), p -> p.getReviews()
                        .stream()
                        .filter(r -> r.getTimestamp().isAfter(last3Months))
                        .mapToInt(Review::getRating)
                        .average()
                        .orElse(0)))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() >= 3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("============");
        bestSellingProduct.forEach((k, v) -> System.out.println(k.getName() + "====" + v));
    }
}
