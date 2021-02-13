package ru.netology.domain;

public class Smartphone extends Product {
    private String manufacturer;


    public Smartphone(int id, String nameProduct, int priceProduct, String manufacturer) {
        super(id, nameProduct, priceProduct);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}
