package com.org.complex;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TopSellingProducts {

    public static void main(String[] args) {
        System.out.println("Analyze sales data to find the top-selling products");
        List<Sales> sales = generateSalesData();
        //sales.forEach(System.out::println);
        //max quantity sold
        TopSellingProducts topSellingProducts = new TopSellingProducts();
        topSellingProducts.topSellingProducts(sales);

    }

    private static List<Sales> generateSalesData() {
        return IntStream.rangeClosed(1, 50)
                .mapToObj(i -> new Sales(i, "Product" + i, (int) (Math.random() * 1000), 2023, (int) (Math.random() * 10000)))
                .collect(Collectors.toList());
    }

    void topSellingProducts(List<Sales> sales) {
        final int maxSoldQty = sales.stream().mapToInt(Sales::getSoldQty).max().orElse(0);
        System.out.println("Max Sold Quantity: " + maxSoldQty);

        final List<Sales> topSal = sales.stream().sorted(((o1, o2) -> o2.getSoldQty() - o1.getSoldQty())).limit(10).collect(Collectors.toList());
        System.out.println(topSal);
        System.out.println("Top 5 Selling Products: ");
        sales.stream().filter(s -> s.getSoldQty() == maxSoldQty).forEach(System.out::println);

    }


}



