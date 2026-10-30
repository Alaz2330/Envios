package controllers;

import services.ShippingService;
import views.ShippingView;

public class ShippingController{

    private ShippingView view;

    public ShippingController(ShippingView view) {
        this.view = view;
        this.view.setSaveClick(event -> saveShipping());
        this.view.setTableSelectionListener(event -> {
            getSelectedShippingId();
        });
        this.view.setRemoveClick(event -> removeShipping());
        showShippings();
    }

    private void saveShipping() {
        var type = view.getShippingTypeSelected();
        var client = view.getClientName();
        var shippingId = view.getIdNumber();
        var weight = view.getWeight();
        var distance = view.getDistance();
        ShippingService.add(type, client, shippingId, weight, distance);
        showShippings();
    }

    private void showShippings() {
        view.showShippings(ShippingService.getData(), ShippingService.getHeaders());
    }

    private void getSelectedShippingId() {
        int index = view.getSelectedShipping();
        if (index >=0) {
            var shipping = ShippingService.get(index);
            if (shipping != null) {
                view.setTxtRemoveShippingId(shipping.getidShipping());
            }
        }
    }

    private void removeShipping() {
        String shippingId = view.getIdNumberForRemoving();
        if (shippingId == null || shippingId.trim().isEmpty()) {
            return;
        }

        boolean confirmation = view.confirm("Esta seguro de eliminar el envio?");
        if (confirmation) {
            boolean removed = ShippingService.removeShippingById(shippingId);
            if (removed) {
                view.showMessage("El envio ha sido eliminado");
                showShippings();
            } else {
                view.showMessage("No se encontro ningun envio con el ID proporcionado");
            }
        }
    }
}