package coffee.charlene.ch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

/**
 * Unit test for {@link Coffee}
 */
public class ReceiptTest {

    @Test
    public void shouldPrintSummaryOfEmptyOrder() {
        final Receipt order = new Receipt(new Order(List.of()), BeverageStamp.ZERO);
        Assertions.assertEquals("=== RECEIPT ========================\n" +
                "Stamps: 0\n" +
                "Items: \n" +
                "TOTAL: 0.00 CHF\n" +
                "New Stamps: 0\n" +
                "====================================", order.toSummaryString());
        Assertions.assertEquals(0, order.getTotalPrice());
    }

    @Test
    public void shouldPrintOrderWithEntriesAndStamp() {
        final Receipt order = new Receipt(
                new Order(
                        List.of(
                                new Coffee(CoffeeSize.MEDIUM, List.of(new FoamedMilk())),
                                new BaconRoll(),
                                new OrangeJuice()
                        ),
                        BeverageStamp.THREE
                ),
                BeverageStamp.ONE
        );
        Assertions.assertEquals("=== RECEIPT ========================\n" +
                "Stamps: 3\n" +
                "Items: \n" +
                "- Coffee (medium) 3.00 CHF\n" +
                "   - Foamed milk 0.50 CHF\n" +
                "- Bacon Roll 4.50 CHF\n" +
                "- Freshly squeezed orange juice (0.25l) 3.95 CHF\n" +
                "TOTAL: 11.95 CHF\n" +
                "New Stamps: 1\n" +
                "====================================", order.toSummaryString());
        Assertions.assertEquals(11.95, order.getTotalPrice(), TestConstants.PRICE_EPSILON);
    }
}
