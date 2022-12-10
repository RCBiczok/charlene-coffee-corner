package coffee.charlene.ch;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link ExtraMilk}
 */
public class ExtraMilkTest {

    @Test
    public void shouldHaveFixedPropertiesExceptPrice() {
        final ExtraMilk extraMilk = new ExtraMilk();
        Assertions.assertEquals("Extra milk", extraMilk.getProductName());
        Assertions.assertEquals("- Extra milk 0.30 CHF", extraMilk.getReceiptLines());
        Assertions.assertEquals(0.3, extraMilk.getPrice(), TestConstants.PRICE_EPSILON);
        Assertions.assertEquals(0.3, extraMilk.getTotalPrice(), TestConstants.PRICE_EPSILON);
        extraMilk.setPrice(0);
        Assertions.assertEquals("- Extra milk 0.00 CHF", extraMilk.getReceiptLines());
        Assertions.assertEquals(0.0, extraMilk.getPrice(), TestConstants.PRICE_EPSILON);
        Assertions.assertEquals(0.0, extraMilk.getTotalPrice(), TestConstants.PRICE_EPSILON);
    }
}
