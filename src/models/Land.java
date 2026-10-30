package models;

import java.text.DecimalFormat;

public class Land extends Shipping {
    private static final double TARIFF = 1500;
    private static final double CHARGE = 2000;

    public Land(String client, String shippingId, double weight, double distance) {
        super(client, shippingId, weight, distance);   
    }

    @Override
    public double calculateTariff() {
        return getWeight() * CHARGE + getDistance() * TARIFF;
    }

    @Override 
    public String[] getData() {
        DecimalFormat money = new DecimalFormat("#,##0.00");
        DecimalFormat metric = new DecimalFormat("#,##0");
        double weight = getWeight();
        double distance = getDistance();
    
        return new String[] {
            "TERRESTRE",
            getidShipping(),
            getClient(),
            metric.format(weight),
            metric.format(distance),
            money.format(calculateTariff())
        };
    };    
}
