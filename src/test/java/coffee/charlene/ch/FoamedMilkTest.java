package coffee.charlene.ch;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link FoamedMilk}
 */
public class FoamedMilkTest {
    @Test
    public void shouldHaveFixedProperties() {
        final FoamedMilk foamedMilk = new FoamedMilk();
        Assertions.assertEquals("Foamed milk", foamedMilk.getProductName());
        Assertions.assertEquals("- Foamed milk 0.50 CHF", foamedMilk.getReceiptLines());
        Assertions.assertEquals(0.5, foamedMilk.getPrice(), 0.001);
        Assertions.assertEquals(0.5, foamedMilk.getTotalPrice(), 0.001);
    }
}
