package coffee.charlene.ch;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link OrangeJuice}
 */
public class OrangeJuiceTest {
    @Test
    public void shouldHaveFixedProperties() {
        final OrangeJuice orangeJuice = new OrangeJuice();
        Assertions.assertEquals("Freshly squeezed orange juice (0.25l)", orangeJuice.getProductName());
        Assertions.assertEquals("- Freshly squeezed orange juice (0.25l) 3.95 CHF", orangeJuice.getReceiptLines());
        Assertions.assertEquals(3.95, orangeJuice.getPrice(), 0.001);
        Assertions.assertEquals(3.95, orangeJuice.getTotalPrice(), 0.001);
    }
}
