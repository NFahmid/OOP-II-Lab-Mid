package Source;

import IceCreamFlavour.IceCreamFlavor;
import Serving.Serving;
import Topping.Topping;

import java.util.List;

public interface PricingStrategy {
    double calculateSubtotal(List<IceCreamFlavor> scoops, List<Topping> toppings, Serving serving);
    double applyTax(double subtotal);
    String generateInvoice(List<IceCreamFlavor> scoops, List<Topping> toppings, Serving serving);
}

