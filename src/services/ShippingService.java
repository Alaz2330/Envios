package services;

import java.util.ArrayList;
import java.util.List;

import factory.ShippingFactory;
import models.Shipping;
import models.ShippingType;

public class ShippingService {
    
    private static String[] headers = {"Tipo", "Codigo ID", "Cliente", "Peso (Kg)", "Distancia (Km)", "Costo"};

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

    public static void add(ShippingType type, String shippingId, String client, double weight, double distance) {
        var shipping = ShippingFactory.createShipping(type, shippingId, client, weight, distance);
        if(shipping != null) 
            shippings.add(shipping);
    }

    public static String[][] getData() {
        String[][] shippingData = new String[shippings.size()][headers.length];
        int row = 0;
        for (Shipping shipping : shippings) {
            int column = 0;
            for (var data : shipping.getData()) {
                shippingData[row][column] = data; 
                column++;
            }
            row++;
        }
        return shippingData;
    }

    public static boolean removeShippingById(String shippingId) {
        return shippings.removeIf(shipping -> shipping.getidShipping().equals(shippingId));
    }
}
