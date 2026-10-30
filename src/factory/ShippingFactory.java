package factory;

import models.Shipping;
import models.ShippingType;
import models.Air;
import models.Land;
import models.Sea;

public class ShippingFactory{
    
    public static Shipping createShipping(ShippingType type, String shippingId, String client, double weight, double distance) {
        return switch (type) {
            case AEREO -> new Air(shippingId, client, weight, distance);
            case TERRESTRE -> new Land(shippingId, client, weight, distance);
            case MAIRITIMO -> new Sea(shippingId, client, weight, distance);
        };
    }
}
