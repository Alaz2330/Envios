package models;

public class Air extends Shipping {
    private static final double TARIFF = 5000;
    private static final double CHARGE = 4000;

    public Air(String client, String idShString, double weight, double distance) {
        super(client, idShString, weight, distance, TARIFF, CHARGE);   
    }
}
