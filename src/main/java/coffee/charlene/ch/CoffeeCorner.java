package coffee.charlene.ch;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class CoffeeCorner {
    private CoffeeCorner() {
    }

    /**
     * Assumptions:
     *  * Stamps can "stack" (e.g. 4 stamps + 6 ordered beverages = 10 stamps -> 2 free beverages)
     *  * We discount the most expensive beverages first
     *  * Discounted beverages do not count as stamps (4 stamps + 1 order -> new stamp card starts with 0)
     *  * Discounted per beverage does not include extras.
     *  * There can be at most one discount for an extra if there is at least one beverage and one snack
     *  * The {@link Order} object can be altered in-place
     * @param order the order from the customer
     * @return the processed order
     */
    public static Receipt processReceipt(final Order order) {

        return processCombos(processStamps(new Receipt(order, order.getBeverageStamp())));
    }

    private static Receipt processCombos(final Receipt receipt) {
        final List<Drinkable> drinkable = receipt.getOrder().getItems().stream()
                .filter(e -> Drinkable.class.isAssignableFrom(e.getClass()))
                .map(Drinkable.class::cast)
                .sorted((c1, c2) -> Double.compare(c2.getPrice(), c1.getPrice()))
                .collect(Collectors.toList());
        final int stamps = receipt.getOrder().getBeverageStamp().getStampCount() + drinkable.size();
        drinkable.stream()
                .limit(stamps / BeverageStamp.values().length)
                .forEach(d -> d.setPrice(0));
        return new Receipt(receipt.getOrder(), BeverageStamp.values()[stamps % BeverageStamp.values().length]);
    }

    private static Receipt processStamps(final Receipt receipt) {
        final Stream<Drinkable> drinkable = receipt.getOrder().getItems().stream()
                .filter(e -> Drinkable.class.isAssignableFrom(e.getClass()))
                .map(Drinkable.class::cast);
        final Stream<Eatable> eatables = receipt.getOrder().getItems().stream()
                .filter(e -> Eatable.class.isAssignableFrom(e.getClass()))
                .map(Eatable.class::cast);

        if(drinkable.findAny().isEmpty() || eatables.findAny().isEmpty()) {
            return receipt;
        }

        receipt.getOrder().getItems().stream()
                .filter(e -> Customizable.class.isAssignableFrom(e.getClass()))
                .map(Customizable.class::cast)
                .flatMap(e -> (Stream<? extends Addable>)e.getExtras().stream())
                .sorted((c1, c2) -> Double.compare(c2.getPrice(), c1.getPrice()))
                .limit(1)
                .forEach(d -> d.setPrice(0));
        return new Receipt(receipt.getOrder(), receipt.getBeverageStamp());
    }

}
