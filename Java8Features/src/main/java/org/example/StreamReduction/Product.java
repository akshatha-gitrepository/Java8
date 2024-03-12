package org.example.StreamReduction;

public class Product {

    private String productName;
    private int price;


    public Product( int price,String productName) {
        this.productName = productName;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return
                "productName='" + productName + '\'' +
                ", price=" + price ;
    }
}
