package com.company;

import java.util.Random;

public class Cart {

    int productId;
    float productPrice;
    String productName;



    public Cart() {
        this.productId = new Random().nextInt(1000);
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public float getProductPrice() {
        return this.productPrice;
    }


    @Override
    public String toString() {
        return "Item id: " + this.productId + " .This product is called " + this.productName + ". It costs " +
                this.productPrice + "$";
    }
}
