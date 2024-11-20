package Source;

import IceCreamFlavour.IceCreamFlavor;
import Serving.Serving;
import Topping.Topping;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<IceCreamFlavor> scoops;
    private List<Topping> toppings;
    private Serving serving;
    private PricingStrategy pricingStrategy;

    public Order(PricingStrategy pricingStrategy) {
        this.scoops = new ArrayList<>();
        this.toppings = new ArrayList<>();
        this.pricingStrategy = pricingStrategy;
    }

    public void addScoop(IceCreamFlavor flavor) {
        scoops.add(flavor);
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public void setServing(Serving serving) {
        this.serving = serving;
    }

    public double calculateTotal() {
        double subtotal = pricingStrategy.calculateSubtotal(scoops, toppings, serving);
        return pricingStrategy.applyTax(subtotal);
    }

    public String generateInvoice() {
        return pricingStrategy.generateInvoice(scoops, toppings, serving);
    }
}

