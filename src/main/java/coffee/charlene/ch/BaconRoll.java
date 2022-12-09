package coffee.charlene.ch;

/**
 * Represents beacon roll.
 */
public class BaconRoll implements Eatable {
    @Override
    public String getProductName() {
        return "Bacon Roll";
    }

    @Override
    public double getPrice() {
        return 4.5;
    }
}
