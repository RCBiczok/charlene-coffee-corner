package coffee.charlene.ch;

/**
 * Represents orange juice.
 */
public class OrangeJuice implements Drinkable {

    private double price = 3.95;

    @Override
    public String getProductName() {
        return "Freshly squeezed orange juice (0.25l)";
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(final double price) {
        this.price = price;
    }
}
