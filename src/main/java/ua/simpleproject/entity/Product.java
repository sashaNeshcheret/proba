package ua.simpleproject.entity;

public class Product {
    private static int id;
    private int codeProduct;
    private String name;
    private boolean countable;

    public Product(int id, int codeProduct, String name, boolean countable) {
        this.id = id;
        this.codeProduct = codeProduct;
        this.name = name;
        this.countable = countable;
    }

    public int getId() {
        return id;
    }
    public int getCodeProduct() {
        return codeProduct;
    }
    public String getName() {
        return name;
    }
    public boolean isCountable() {
        return countable;
    }
}
