package models;

public abstract class Shipping {
    private String client;
    private String idShipping;
    private double weight;
    private double distance;
    private double tariffBasedPerKm;
    private double chargePerKg;
    
    public abstract double calculateTariff(); 
    
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
    
    public double getTariffBasedPerKm() {
        return tariffBasedPerKm;
    }

    public double getChargePerKg() {
        return chargePerKg;
    }
}
