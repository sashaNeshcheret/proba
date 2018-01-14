package ua.simpleproject.entity;

public class CurrentCheck {
    private static int id;
    private int userId;
    private int productID;
    private int count;
    private int priceForOne;
    private int resultPrice;
    public CurrentCheck(int id, int userId, int productID, int count, int priceForOne, int resultPrice) {
        this.userId = userId;
        this.productID = productID;
        this.count = count;
        this.priceForOne = priceForOne;
        this.resultPrice = resultPrice;
    }
    public CurrentCheck(int userId, int productID, int count, int priceForOne, int resultPrice) {
        id++;
        this.userId = userId;
        this.productID = productID;
        this.count = count;
        this.priceForOne = priceForOne;
        this.resultPrice = resultPrice;
    }
    public static int getId() {
        return id;
    }
    public int getUserId() {
        return userId;
    }
    public int getProductID() {
        return productID;
    }
    public int getCount() {
        return count;
    }
    public int getPriceForOne() {
        return priceForOne;
    }
    public int getResultPrice() {
        return resultPrice;
    }
}
