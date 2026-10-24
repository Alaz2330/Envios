package factory;

import models.Shipping;
import models.ShippingType;
import models.Air;
import models.Land;
import models.Sea;

public class ShippingFactory{
    
    public static Shipping createShipping(ShippingType type, String client, String shippingId, double weight, double distance) {
        return switch (type) {
            case AIR -> new Air(client, shippingId, weight, distance);
            case LAND -> new Land(client, shippingId, weight, distance);
            case SEA -> new Sea(client, shippingId, weight, distance);
        };
    }
}