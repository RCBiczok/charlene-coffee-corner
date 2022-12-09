package coffee.charlene.ch;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link BaconRoll}
 */
public class BaconRollTest {
    @Test
    public void shouldHaveFixedProperties() {
        final BaconRoll baconRoll = new BaconRoll();
        Assertions.assertEquals("Bacon Roll", baconRoll.getProductName());
        Assertions.assertEquals("- Bacon Roll 4.50 CHF", baconRoll.getReceiptLines());
        Assertions.assertEquals(4.5, baconRoll.getPrice(), 0.001);
        Assertions.assertEquals(4.5, baconRoll.getTotalPrice(), 0.001);
    }
}
