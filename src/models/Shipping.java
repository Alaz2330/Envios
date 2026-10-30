package models;

import java.text.DecimalFormat;
import java.util.Objects;

public abstract class Shipping {
    private String client;
    private String shippingId;
    private double weight;
    private double distance;

    public Shipping(String client, String shippingId, double weight, double distance) {
        this.client = client;
        this.shippingId = shippingId;
        this.weight = weight;
        this.distance = distance;
    }
    
    public abstract double calculateTariff(); 
    
    public String getClient() {
        return client;
    }
    public String getidShipping() {
        return shippingId;
    }
    public double getWeight() {
        return weight;
    }
    public double getDistance() {
        return distance;
    }

    public abstract String[] getData();

    @Override 
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Shipping shipping = (Shipping) obj;
        return Objects.equals(shippingId, shipping.shippingId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shippingId);
    }
}
