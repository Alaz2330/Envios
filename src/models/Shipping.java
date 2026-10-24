package models;

public abstract class Shipping {
    private String client;
    private String ShippingId;
    private double weight;
    private double distance;

    public Shipping(String client, String shippingId, double weight, double distance) {
        this.client = client;
        this.ShippingId = shippingId;
        this.weight = weight;
        this.distance = distance;
    }
    
    public abstract double calculateTariff(double weight, double distance); 
    
    public String getClient() {
        return client;
    }
    public String getidShipping() {
        return ShippingId;
    }
    public double getWeight() {
        return weight;
    }
    public double getDistance() {
        return distance;
    }
}
