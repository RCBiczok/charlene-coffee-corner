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
                "- Freshly squeezed orange juice (0.25l) 3.95 CHF\n" +
                "TOTAL: 7.45 CHF\n" +
                "New Stamps: 3\n" +
                "====================================", order.toSummaryString());
    }

    @Test
    public void shouldDiscountExtra() {
        final Receipt order = CoffeeCorner.processReceipt(
                new Order(
                        List.of(
                                new Coffee(CoffeeSize.MEDIUM, List.of(new FoamedMilk())),
                                new BaconRoll(),
                                new Coffee(CoffeeSize.MEDIUM, List.of(new SpecialRoastCoffee()))
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
                "- Coffee (medium) 3.00 CHF\n" +
                "   - Special roast coffee 0.00 CHF\n" +
                "TOTAL: 11.00 CHF\n" +
                "New Stamps: 3\n" +
                "====================================", order.toSummaryString());
    }

    @Test
    public void shouldHandleFreeBeverage() {
        final Receipt order = CoffeeCorner.processReceipt(
                new Order(
                        List.of(
                                new Coffee(CoffeeSize.MEDIUM, List.of(new FoamedMilk()))
                        ),
                        BeverageStamp.FOUR
                )
        );
        Assertions.assertEquals("=== RECEIPT ========================\n" +
                "Stamps: 4\n" +
                "Items: \n" +
                "- Coffee (medium) 0.00 CHF\n" +
                "   - Foamed milk 0.50 CHF\n" +
                "TOTAL: 0.50 CHF\n" +
                "New Stamps: 0\n" +
                "====================================", order.toSummaryString());
    }

    @Test
    public void shouldHandleOrderWithNoExtras() {
        final Receipt order = CoffeeCorner.processReceipt(
                new Order(
                        List.of(
                                new OrangeJuice(),
                                new BaconRoll()
                        ),
                        BeverageStamp.TWO
                )
        );
        Assertions.assertEquals("=== RECEIPT ========================\n" +
                "Stamps: 2\n" +
                "Items: \n" +
                "- Freshly squeezed orange juice (0.25l) 3.95 CHF\n" +
                "- Bacon Roll 4.50 CHF\n" +
                "TOTAL: 8.45 CHF\n" +
                "New Stamps: 3\n" +
                "====================================", order.toSummaryString());
    }

    @Test
    public void shouldStackFreeBeverage() {
        final Receipt order = CoffeeCorner.processReceipt(
                new Order(
                        List.of(
                                new Coffee(CoffeeSize.MEDIUM, List.of(new FoamedMilk())),
                                new OrangeJuice(),
                                new OrangeJuice(),
                                new OrangeJuice(),
                                new OrangeJuice(),
                                new OrangeJuice(),
                                new OrangeJuice(),
                                new OrangeJuice()
                        ),
                        BeverageStamp.FOUR
                )
        );
        Assertions.assertEquals("=== RECEIPT ========================\n" +
                "Stamps: 4\n" +
                "Items: \n" +
                "- Coffee (medium) 3.00 CHF\n" +
                "   - Foamed milk 0.50 CHF\n" +
                "- Freshly squeezed orange juice (0.25l) 0.00 CHF\n" +
                "- Freshly squeezed orange juice (0.25l) 0.00 CHF\n" +
                "- Freshly squeezed orange juice (0.25l) 3.95 CHF\n" +
                "- Freshly squeezed orange juice (0.25l) 3.95 CHF\n" +
                "- Freshly squeezed orange juice (0.25l) 3.95 CHF\n" +
                "- Freshly squeezed orange juice (0.25l) 3.95 CHF\n" +
                "- Freshly squeezed orange juice (0.25l) 3.95 CHF\n" +
                "TOTAL: 23.25 CHF\n" +
                "New Stamps: 2\n" +
                "====================================", order.toSummaryString());
    }

    @Test
    public void shouldStackFreeBeverageWithSnack() {
        final Receipt order = CoffeeCorner.processReceipt(
                new Order(
                        List.of(
                                new Coffee(CoffeeSize.MEDIUM, List.of(new FoamedMilk())),
                                new OrangeJuice(),
                                new OrangeJuice(),
                                new OrangeJuice(),
                                new OrangeJuice(),
                                new OrangeJuice(),
                                new OrangeJuice(),
                                new OrangeJuice(),
                                new BaconRoll()
                        ),
                        BeverageStamp.FOUR
                )
        );
        Assertions.assertEquals("=== RECEIPT ========================\n" +
                "Stamps: 4\n" +
                "Items: \n" +
                "- Coffee (medium) 3.00 CHF\n" +
                "   - Foamed milk 0.00 CHF\n" +
                "- Freshly squeezed orange juice (0.25l) 0.00 CHF\n" +
                "- Freshly squeezed orange juice (0.25l) 0.00 CHF\n" +
                "- Freshly squeezed orange juice (0.25l) 3.95 CHF\n" +
                "- Freshly squeezed orange juice (0.25l) 3.95 CHF\n" +
                "- Freshly squeezed orange juice (0.25l) 3.95 CHF\n" +
                "- Freshly squeezed orange juice (0.25l) 3.95 CHF\n" +
                "- Freshly squeezed orange juice (0.25l) 3.95 CHF\n" +
                "- Bacon Roll 4.50 CHF\n" +
                "TOTAL: 27.25 CHF\n" +
                "New Stamps: 2\n" +
                "====================================", order.toSummaryString());
    }
}
