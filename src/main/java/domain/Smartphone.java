package domain;

public class Smartphone extends Product {
    private String Brand;

    public Smartphone() {
        super();
    }

    public Smartphone(String name, int id, int price, String brand) {
        super(name, id, price);
        Brand = brand;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }
}
