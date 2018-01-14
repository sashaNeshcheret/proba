package ua.simpleproject.entity;

public class CheckReports {
    private  int id;
    private int userId;
    private int numberOfProduct;
    private int checkAmount;

    public CheckReports(int id, int userId, int numberOfProduct, int checkAmount) {
        this.id = id;
        this.userId = userId;
        this.numberOfProduct = numberOfProduct;
        this.checkAmount = checkAmount;
    }

    public CheckReports(int userId, int numberOfProduct, int checkAmount) {
        this.userId = userId;
        this.numberOfProduct = numberOfProduct;
        this.checkAmount = checkAmount;
    }

    public int getId() {
        return id;
    }
    public int getUserId() {
        return userId;
    }
    public int getNumberOfProduct() {
        return numberOfProduct;
    }
    public int getCheckAmount() {
        return checkAmount;
    }
}
