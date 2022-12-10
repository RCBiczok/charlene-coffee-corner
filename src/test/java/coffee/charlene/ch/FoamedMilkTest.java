package coffee.charlene.ch;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link FoamedMilk}
 */
public class FoamedMilkTest {
    @Test
    public void shouldHaveFixedPropertiesExceptPrice() {
        final FoamedMilk foamedMilk = new FoamedMilk();
        Assertions.assertEquals("Foamed milk", foamedMilk.getProductName());
        Assertions.assertEquals("- Foamed milk 0.50 CHF", foamedMilk.getReceiptLines());
        Assertions.assertEquals(0.5, foamedMilk.getPrice(), TestConstants.PRICE_EPSILON);
        Assertions.assertEquals(0.5, foamedMilk.getTotalPrice(), TestConstants.PRICE_EPSILON);
        foamedMilk.setPrice(0);
        Assertions.assertEquals("- Foamed milk 0.00 CHF", foamedMilk.getReceiptLines());
        Assertions.assertEquals(0.0, foamedMilk.getPrice(), TestConstants.PRICE_EPSILON);
        Assertions.assertEquals(0.0, foamedMilk.getTotalPrice(), TestConstants.PRICE_EPSILON);
    }
}
