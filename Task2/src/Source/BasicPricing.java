package Source;

import java.util.List;

public class BasicPricing implements PricingStrategy {
    @Override
    public double calculateSubtotal(List<IceCreamFlavor> scoops, List<Topping> toppings, Serving serving) {
        double subtotal = scoops.stream().mapToDouble(IceCreamFlavor::getPricePerScoop).sum()
                + toppings.stream().mapToDouble(Topping::getPrice).sum()
                + serving.getPrice();
        return subtotal;
    }

    @Override
    public double applyTax(double subtotal) {
        return subtotal * 1.08; // Adding 8% tax
    }

    @Override
    public String generateInvoice(List<IceCreamFlavor> scoops, List<Topping> toppings, Serving serving) {
        StringBuilder invoice = new StringBuilder("Ice Cream Shop Invoice\n");
        scoops.forEach(scoop -> invoice.append(scoop.getName())
                .append(" - 1 scoop: $")
                .append(String.format("%.2f", scoop.getPricePerScoop()))
                .append("\n"));
        toppings.forEach(topping -> invoice.append(topping.getName())
                .append(" - 1 time: $")
                .append(String.format("%.2f", topping.getPrice()))
                .append("\n"));
        invoice.append("Serving: ").append(serving.getName()).append(" - $").append(String.format("%.2f", serving.getPrice())).append("\n");
        double subtotal = calculateSubtotal(scoops, toppings, serving);
        invoice.append("Subtotal: $").append(String.format("%.2f", subtotal)).append("\n");
        invoice.append("Tax: $").append(String.format("%.2f", subtotal * 0.08)).append("\n");
        invoice.append("Total Amount Due: $").append(String.format("%.2f", applyTax(subtotal)));
        return invoice.toString();
    }
}
