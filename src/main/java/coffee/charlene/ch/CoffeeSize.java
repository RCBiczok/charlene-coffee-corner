package coffee.charlene.ch;

public enum CoffeeSize {
    SMALL(2.5),
    MEDIUM(3.0),
    LARGE(3.5);

    private final double price;
    CoffeeSize(final double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
