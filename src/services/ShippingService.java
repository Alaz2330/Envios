package services;

import java.util.ArrayList;
import java.util.List;

import factory.ShippingFactory;
import models.Shipping;
import models.ShippingType;

public class ShippingService {
    
    private static String[] headers = {"Type", "Shipping ID", "Client", "Distance", "Weight", "Charge"};

    private static List<Shipping> shippings = new ArrayList<>();

    public static String[] getHeaders() {
        return headers;
    }

    public static Shipping get(int index) {
        if (index >= 0 && index<shippings.size()) {
            return shippings.get(index);
        }
        return null;
    }

    public static void add(ShippingType type, String shippingId, String client, double distance, double weight) {
        var shipping = ShippingFactory.createShipping(type, shippingId, client, distance, weight);
        if(shipping != null) 
            shippings.add(shipping);
    }

    public static String[][] getData() {
        
        return data;
    }
}
