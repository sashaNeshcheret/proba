package ua.simpleproject.entity;

public class Stock {
    private int id;
    private int productId;
    private int number;

    public Stock(int productId, int number) {
        this.productId = productId;
        this.number = number;
    }
    public int getId() {
        return id;
    }
    public int getProductId() {
        return productId;
    }
    public int getNumber() {
        return number;
    }
}
