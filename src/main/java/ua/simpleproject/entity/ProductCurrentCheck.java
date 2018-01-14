package ua.simpleproject.entity;

public class ProductCurrentCheck {

    private String name;
    private int code;
    private int number;
    private int priceForOne;
    private int resultPrice;

    public ProductCurrentCheck() {
    }

    public ProductCurrentCheck(String name, int code, int number, int priceForOne, int resultPrice) {
        this.name = name;
        this.code = code;
        this.number = number;
        this.priceForOne = priceForOne;
        this.resultPrice = resultPrice;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public int getPriceForOne() {
        return priceForOne;
    }
    public void setPriceForOne(int priceForOne) {
        this.priceForOne = priceForOne;
    }
    public int getResultPrice() {
        return resultPrice;
    }
    public void setResultPrice(int resultPrice) {
        this.resultPrice = resultPrice;
    }

}
