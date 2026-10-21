package models;

public class Land extends Shipping {
    private static final double TARIFF = 1500;
    private static final double CHARGE = 2000;

    public Land(String client, String idShString, double weight, double distance) {
        super(client, idShString, weight, distance, TARIFF, CHARGE);   
    }
}
