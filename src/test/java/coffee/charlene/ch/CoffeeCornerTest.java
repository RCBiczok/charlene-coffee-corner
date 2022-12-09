package coffee.charlene.ch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Unit test for {@link Coffee}
 */
public class CoffeeCornerTest {

    @Test
    public void shouldAddUpBeveragesToStamp() {
        final Receipt order = CoffeeCorner.processReceipt(
                new Order(
                        List.of(
                                new Coffee(CoffeeSize.MEDIUM, List.of(new FoamedMilk())),
                                new BaconRoll(),
                                new OrangeJuice()
                        ),
                        BeverageStamp.ONE
                )
        );
        Assertions.assertEquals("=== RECEIPT ========================\n" +
                "Stamps: 1\n" +
                "Items: \n" +
                "- Coffee (medium) 3.00 CHF\n" +
                "   - Foamed milk 0.50 CHF\n" +
                "- Bacon Roll 4.50 CHF\n" +
                "- Freshly squeezed orange juice (0.25l) 3.95 CHF\n" +
                "Deducted items: \n" +
                "TOTAL: 11.95 CHF\n" +
                "New Stamps: 3\n" +
                "====================================", order.toSummaryString());
    }

    @Test
    public void shouldHandleFreeBeverage() {
        final Receipt order = CoffeeCorner.processReceipt(
                new Order(
                        List.of(
                                new Coffee(CoffeeSize.MEDIUM, List.of(new FoamedMilk())),
                                new BaconRoll()
                        ),
                        BeverageStamp.FOUR
                )
        );
        Assertions.assertEquals("=== RECEIPT ========================\n" +
                "Stamps: 4\n" +
                "Items: \n" +
                "- Coffee (medium) 3.00 CHF\n" +
                "   - Foamed milk 0.50 CHF\n" +
                "- Bacon Roll 4.50 CHF\n" +
                "Deducted items: \n" +
                "- Coffee (medium) 3.00 CHF\n" +
                "   - Foamed milk 0.50 CHF\n" +
                "TOTAL: 4.50 CHF\n" +
                "New Stamps: 0\n" +
                "====================================", order.toSummaryString());
    }
}
