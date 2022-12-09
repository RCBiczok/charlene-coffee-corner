package coffee.charlene.ch;

/**
 * Represents an extra for a coffee.
 * Assumption is that no extra can be purchased without a {@link Coffee}
 * and it cannot be between {@link Coffee} instances
 */
public class ExtraMilk implements CoffeeAddable {
    @Override
    public String getProductName() {
        return "Extra milk";
    }

    @Override
    public double getPrice() {
        return 0.3;
    }
}
