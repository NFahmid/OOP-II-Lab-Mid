import IceCreamFlavour.*;
import Serving.*;
import Source.*;
import Topping.*;

public class Main {
    public static void main(String[] args) {
        Order order = new Order(new BasicPricing());
        order.addScoop(new MintChocolateChip());
        order.addScoop(new ChocolateFudge());
        order.addTopping(new ChocolateChips());
        order.addTopping(new FreshStrawberries());
        order.setServing(new PaperCup());

        System.out.println(order.generateInvoice());
    }
}
