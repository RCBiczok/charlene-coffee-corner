package coffee.charlene.ch;

/**
 * Represents beacon roll.
 */
public class BaconRoll extends AbstractProduct implements Eatable {
    public BaconRoll() {
        super(4.5);
    }

    @Override
    public String getProductName() {
        return "Bacon Roll";
    }
}
