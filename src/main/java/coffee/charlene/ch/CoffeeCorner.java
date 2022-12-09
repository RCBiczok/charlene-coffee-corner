package coffee.charlene.ch;

public final class CoffeeCorner {
    private CoffeeCorner() {
    }

    public Receipt processReceipt(final Order order) {
        return new Receipt(order, null, order.getBeverageStamp());
    }

}
