package models;

public abstract class Shipping {
    private String client;
    private String idShipping;
    private double weight;
    private double distance;
    private double tariff;
    private double charge;

    public Shipping(String client, String idShString, double weight, double distance, double tariff, double charge) {
        this.client = client;
        this.idShipping = idShString;
        this.weight = weight;
        this.distance = distance;
        this.tariff = tariff;
        this.charge = charge;
    }
    
    public double calculateTariff() {
        return (this.distance * this.tariff) + (this.weight * this.charge);
    }; 
    
    public String getClient() {
        return client;
    }
    public String getidShipping() {
        return idShipping;
    }
    public double getWeight() {
        return weight;
    }
    public double getDistance() {
        return distance;
    }
}
