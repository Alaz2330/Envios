package models;

public class Land extends Shipping {
    private static final double TARIFF = 1500;
    private static final double CHARGE = 2000;

    public Land(String client, String shippingId, double weight, double distance) {
        super(client, shippingId, weight, distance);   
    }

    @Override
    public double calculateTariff(double weight, double distance) {
        return weight * CHARGE + distance * TARIFF;
    }
}
