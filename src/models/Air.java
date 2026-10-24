package models;

public class Air extends Shipping {
    private static final double TARIFF = 5000;
    private static final double CHARGE = 4000;
    
    public Air(String client, String shippingId, double weight, double distance) {
        super(client, shippingId, weight, distance);   
    }
    
    @Override
    public double calculateTariff(double weight, double distance) {
        return weight * CHARGE + distance * TARIFF;
    }
}
