package controllers;

import services.ShippingService;
import views.ShippingView;

public class ShippingController{

    private ShippingView view;

    public ShippingController(ShippingView view) {
        this.view = view;
        this.view.setSaveClick(event -> saveShipping());
        showShippings();
    }

    private void saveShipping() {
        var type = view.getShippingTypeSelected();
        var client = view.getClientName();
        var shippingId = view.getIdNumber();
        var weight = view.getWeight();
        var distance = view.getDistance();
        ShippingService.add(type, client, shippingId, weight, distance);
    }

    private void showShippings() {
        view.showShippings(ShippingService.getData(), ShippingService.getHeaders());
    }
}