package models;

import java.text.DecimalFormat;

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

    @Override 
    public String[] getData() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        double weight = getWeight();
        double distance = getDistance();
    
        return new String[] {
            "SEA",
            getidShipping(),
            getClient(),
            df.format(weight),
            df.format(distance),
            df.format(calculateTariff(weight, distance))
        };
    };  
}
