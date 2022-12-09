package coffee.charlene.ch;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Unit test for {@link Coffee}
 */
public class CoffeeTest {

    @Test
    public void shouldHaveDifferentPricingTears() {
        final Coffee coffeeSmall = new Coffee(CoffeeSize.SMALL);
        Assertions.assertEquals("Coffee (small)", coffeeSmall.getProductName());
        Assertions.assertEquals("- Coffee (small) 2.50 CHF", coffeeSmall.getReceiptLines());
        Assertions.assertEquals(2.5, coffeeSmall.getPrice(), 0.001);
        Assertions.assertEquals(2.5, coffeeSmall.getTotalPrice(), 0.001);

        final Coffee coffeeMedium = new Coffee(CoffeeSize.MEDIUM);
        Assertions.assertEquals("Coffee (medium)", coffeeMedium.getProductName());
        Assertions.assertEquals("- Coffee (medium) 3.00 CHF", coffeeMedium.getReceiptLines());
        Assertions.assertEquals(3.0, coffeeMedium.getPrice(), 0.001);
        Assertions.assertEquals(3.0, coffeeMedium.getTotalPrice(), 0.001);

        final Coffee coffeeLarge = new Coffee(CoffeeSize.LARGE);
        Assertions.assertEquals("Coffee (large)", coffeeLarge.getProductName());
        Assertions.assertEquals("- Coffee (large) 3.50 CHF", coffeeLarge.getReceiptLines());
        Assertions.assertEquals(3.5, coffeeLarge.getPrice(), 0.001);
        Assertions.assertEquals(3.5, coffeeLarge.getTotalPrice(), 0.001);
    }

    @Test
    public void canContainExtras() {
        final Coffee coffeeSmall = new Coffee(CoffeeSize.SMALL, List.of(new ExtraMilk()));
        Assertions.assertEquals("Coffee (small)", coffeeSmall.getProductName());
        Assertions.assertEquals("- Coffee (small) 2.50 CHF\n" +
                "   - Extra milk 0.30 CHF", coffeeSmall.getReceiptLines());
        Assertions.assertEquals(2.5, coffeeSmall.getPrice(), 0.001);
        Assertions.assertEquals(2.8, coffeeSmall.getTotalPrice(), 0.001);

        final Coffee coffeeMedium = new Coffee(CoffeeSize.MEDIUM, List.of(new SpecialRoastCoffee(), new FoamedMilk()));
        Assertions.assertEquals("Coffee (medium)", coffeeMedium.getProductName());
        Assertions.assertEquals("- Coffee (medium) 3.00 CHF\n" +
                        "   - Special roast coffee 0.90 CHF\n" +
                        "   - Foamed milk 0.50 CHF",
                coffeeMedium.getReceiptLines());
        Assertions.assertEquals(3.0, coffeeMedium.getPrice(), 0.001);
        Assertions.assertEquals(4.4, coffeeMedium.getTotalPrice(), 0.001);
    }
}
