package coffee.charlene.ch;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link SpecialRoastCoffee}
 */
public class SpecialRoastCoffeeTest {
    @Test
    public void shouldHaveFixedProperties() {
        final SpecialRoastCoffee specialRoastCoffee = new SpecialRoastCoffee();
        Assertions.assertEquals("Special roast coffee", specialRoastCoffee.getProductName());
        Assertions.assertEquals("- Special roast coffee 0.90 CHF", specialRoastCoffee.getReceiptLines());
        Assertions.assertEquals(0.9, specialRoastCoffee.getPrice(), 0.001);
        Assertions.assertEquals(0.9, specialRoastCoffee.getTotalPrice(), 0.001);
    }
}
