package coffee.charlene.ch;

/**
 * Represents an extra for a coffee.
 * Assumption is that no extra can be purchased without a {@link Coffee}
 * and it cannot be between {@link Coffee} instances
 */
public class ExtraMilk extends AbstractProduct implements CoffeeAddable {
    public ExtraMilk() {
        super(0.3);
    }

    @Override
    public String getProductName() {
        return "Extra milk";
    }
}
