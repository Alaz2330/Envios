package models;

public class Sea extends Shipping {
    private static final double TARIFF = 800;
    private static final double CHARGE = 1000;

    public Sea(String client, String shippingId, double weight, double distance) {
        super(client, shippingId, weight, distance);   
    }
    
    @Override
    public double calculateTariff(double weight, double distance) {
        return weight * CHARGE + distance * TARIFF;
    }
}
