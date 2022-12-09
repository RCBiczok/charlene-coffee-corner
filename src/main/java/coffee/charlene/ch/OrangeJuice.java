package coffee.charlene.ch;

/**
 * Represents orange juice.
 */
public class OrangeJuice implements Drinkable {
    @Override
    public String getProductName() {
        return "Freshly squeezed orange juice (0.25l)";
    }

    @Override
    public double getPrice() {
        return 3.95;
    }
}
