package com.org.complex;

class Sales{
    int productId;
    String name;
    int soldQty;
    int year;
    int revenue;

    public Sales(int productId, String name, int soldQty, int year, int revenue) {
        this.productId = productId;
        this.name = name;
        this.soldQty = soldQty;
        this.year = year;
        this.revenue = revenue;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSoldQty() {
        return soldQty;
    }

    public void setSoldQty(int soldQty) {
        this.soldQty = soldQty;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", soldQty=" + soldQty +
                ", year=" + year +
                ", revenue=" + revenue +
                '}';
    }
}