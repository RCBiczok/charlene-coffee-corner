package coffee.charlene.ch;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link ExtraMilk}
 */
public class ExtraMilkTest {

    @Test
    public void shouldHaveFixedProperties() {
        final ExtraMilk extraMilk = new ExtraMilk();
        Assertions.assertEquals("Extra milk", extraMilk.getProductName());
        Assertions.assertEquals("- Extra milk 0.30 CHF", extraMilk.getReceiptLines());
        Assertions.assertEquals(0.3, extraMilk.getPrice(), 0.001);
        Assertions.assertEquals(0.3, extraMilk.getTotalPrice(), 0.001);
    }
}
