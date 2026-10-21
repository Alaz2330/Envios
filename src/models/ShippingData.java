package models;

public record ShippingData(String shippingType, 
                           String name, 
                           String shippingId, 
                           Double weight, 
                           Double distance, 
                           Double tariff, 
                           Double charge) {

}
