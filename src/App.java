import models.Shipping;
import views.ShippingView;
import controllers.ShippingController;

public class App {
    public static void main(String[] args) throws Exception {
        var view = new ShippingView();

        new ShippingController(view);

        view.setVisible(true);
            
        }
}
