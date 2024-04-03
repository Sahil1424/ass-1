package com.example.javaassignment1;

public class ProductData {
    private int id;
    private String productName;
    private int recommendationCount;

    public ProductData(int id, String productName, int recommendationCount) {
        this.id = id;
        this.productName = productName;
        this.recommendationCount = recommendationCount;
    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public int getRecommendationCount() {
        return recommendationCount;
    }
}

