package coffee.charlene.ch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Unit test for {@link Coffee}
 */
public class OrderTest {

    @Test
    public void shouldPrintSummaryOfEmptyOrder() {
        final Order order = new Order(List.of());
        Assertions.assertEquals("=== ORDER ========================\n" +
                "Stamps: 0\n" +
                "==================================", order.toSummaryString());
        Assertions.assertEquals(0, order.getTotalPrice());
    }

    @Test
    public void shouldPrintOrderWithEntriesAndStamp() {
        final Order order = new Order(
                List.of(
                        new Coffee(CoffeeSize.MEDIUM, List.of(new FoamedMilk())),
                        new BaconRoll(),
                        new OrangeJuice()
                ),
                BeverageStamp.THREE
        );
        Assertions.assertEquals("=== ORDER ========================\n" +
                "Stamps: 3\n" +
                "- Coffee (medium) 3.00 CHF\n" +
                "   - Foamed milk 0.50 CHF\n" +
                "- Bacon Roll 4.50 CHF\n" +
                "- Freshly squeezed orange juice (0.25l) 3.95 CHF\n" +
                "==================================", order.toSummaryString());
        Assertions.assertEquals(11.95, order.getTotalPrice(), 0.001);
    }
}
