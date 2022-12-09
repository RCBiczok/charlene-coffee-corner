package coffee.charlene.ch;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class CoffeeCorner {
    private CoffeeCorner() {
    }

    /**
     * Assumptions:
     *  * Stamps can "stack" (e.g. 4 stamps + 6 ordered beverages = 10 stamps -> 2 free beverages)
     *  * We discount the most expensive beverages first
     *  * Discounted beverages do not count as stamps (4 stamps + 1 order -> new stamp card starts with 0)
     * @param order the order from the customer
     * @return the processed order
     */
    public static Receipt processReceipt(final Order order) {

        return processStamps(new Receipt(order, Collections.emptyList(), order.getBeverageStamp()));
    }

    private static Receipt processStamps(final Receipt receipt) {
        final List<Drinkable> drinkables = receipt.getOrder().getItems().stream()
                .filter(e -> Drinkable.class.isAssignableFrom(e.getClass()))
                .map(Drinkable.class::cast)
                .sorted((a, b) -> (int) (a.getPrice() - b.getPrice())).collect(Collectors.toList());
        final int stamps = receipt.getOrder().getBeverageStamp().getStampCount() + drinkables.size();
        final List<Drinkable> freeBeverages = drinkables.stream()
                .limit(stamps / BeverageStamp.values().length)
                .collect(Collectors.toList());
        return new Receipt(receipt.getOrder(), freeBeverages, BeverageStamp.values()[stamps % BeverageStamp.values().length]);
    }

}
