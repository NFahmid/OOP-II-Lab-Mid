import Source.*;

public class Main {
    public static void main(String[] args) {
        Order order = new Order(new BasicPricing());
        order.addScoop(new MintChocolateChip());
        order.addScoop(new ChocolateFudge());
        order.addTopping(new Sprinkles());
        order.addTopping(new FreshStrawberries());
        order.setServing(new WaffleCone());

        System.out.println(order.generateInvoice());
    }
}
