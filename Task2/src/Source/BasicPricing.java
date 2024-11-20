package Source;

import IceCreamFlavour.IceCreamFlavor;
import Serving.Serving;
import Topping.Topping;

import java.util.List;

public class BasicPricing implements PricingStrategy {
    @Override
    public double calculateSubtotal(List<IceCreamFlavor> scoops, List<Topping> toppings, Serving serving) {
        double subtotal = 0.0;

        for (IceCreamFlavor scoop : scoops) {
            subtotal += scoop.getPricePerScoop();
        }

        for (Topping topping : toppings) {
            subtotal += topping.getPrice();
        }

        subtotal += serving.getPrice();

        return subtotal;
    }


    @Override
    public double applyTax(double subtotal) {
        return subtotal * 1.08;
    }

    @Override
    public String generateInvoice(List<IceCreamFlavor> scoops, List<Topping> toppings, Serving serving) {
        String invoice = "Ice Cream Shop Invoice\n";

        for (IceCreamFlavor scoop : scoops) {
            invoice += scoop.getName() + " - 1 scoop: $" + String.format("%.2f", scoop.getPricePerScoop()) + "\n";
        }

        for (Topping topping : toppings) {
            invoice += topping.getName() + " - 1 time: $" + String.format("%.2f", topping.getPrice()) + "\n";
        }

        invoice += "Serving: " + serving.getName() + " - $" + String.format("%.2f", serving.getPrice()) + "\n";

        double subtotal = calculateSubtotal(scoops, toppings, serving);
        double tax = subtotal * 0.08;
        double total = subtotal + tax;

        invoice += "Subtotal: $" + String.format("%.2f", subtotal) + "\n";
        invoice += "Tax: $" + String.format("%.2f", tax) + "\n";
        invoice += "Total Amount Due: $" + String.format("%.2f", total);

        return invoice;
    }


}
