package Test;

import Source.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {
    @Test
    public void testCalculateTotal(){
        Order order = new Order(new BasicPricing());
        order.addScoop(new MintChocolateChip());
        order.addScoop(new ChocolateFudge());
        order.addTopping(new Sprinkles());
        order.addTopping(new FreshStrawberries());
        order.setServing(new WaffleCone());

        double total = order.calculateTotal();
        assertEquals(11.2 * 1.08, total, 0.01);
    }


}
