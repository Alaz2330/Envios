package models;

public class Sea extends Shipping {
    private static final double TARIFF = 800;
    private static final double CHARGE = 1000;

    public Sea(String client, String idShString, double weight, double distance) {
        super(client, idShString, weight, distance, TARIFF, CHARGE);   
    }
}
