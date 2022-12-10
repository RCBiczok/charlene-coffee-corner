package coffee.charlene.ch;

public abstract class AbstractProduct implements Purchasable {

    private double price;

    public AbstractProduct(final double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }
}
