package Test;

import IceCreamFlavour.IceCreamFlavor;
import IceCreamFlavour.MintChocolateChip;
import Serving.Serving;
import Serving.WaffleCone;
import Source.*;
import IceCreamFlavour.ChocolateFudge;
import Topping.CrushedOreo;
import Topping.Sprinkles;
import Topping.Topping;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicPriceTest {
    @Test
    public void testBasicPrice(){
        List<IceCreamFlavor> scoops = List.of(new MintChocolateChip(), new ChocolateFudge());
        List<Topping> toppings = List.of(new Sprinkles(), new CrushedOreo());
        Serving serving = new WaffleCone();

        BasicPricing basicPricing = new BasicPricing();
        double subtotal = basicPricing.calculateSubtotal(scoops, toppings, serving);
        assertEquals(11.95, subtotal, 0.01);
    }

    @Test
    public void testApplyTax(){
        BasicPricing basicPricing = new BasicPricing();
        double tax = basicPricing.applyTax(11.2);
        assertEquals(11.2 * 1.08, tax, 0.01);
    }

    @Test
    public void testInvoiceGenerator(){
        List<IceCreamFlavor> scoops = List.of(new MintChocolateChip(), new ChocolateFudge());
        List<Topping> toppings = List.of(new Sprinkles(), new CrushedOreo());
        Serving serving = new WaffleCone();

        BasicPricing basicPricing = new BasicPricing();
        String invoice = basicPricing.generateInvoice(scoops, toppings, serving);
        String expectedInvoice = "Ice Cream Shop Invoice\n" +
                "Mint Chocolate Chip - 1 scoop: $2.80\n" +
                "ChocolateFudge - 1 scoop: $3.00\n" +
                "Sprinkles - 1 time: $0.30\n" +
                "Crushed Oreo - 1 time: $0.85\n" +
                "Serving: Waffle Cone - $5.00\n" +
                "Subtotal: $11.95\n" +
                "Tax: $0.96\n" +
                "Total Amount Due: $12.91";
        assertEquals(expectedInvoice, invoice);
    }
}
