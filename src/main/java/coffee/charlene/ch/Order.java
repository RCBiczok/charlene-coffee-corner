package coffee.charlene.ch;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static coffee.charlene.ch.Purchasable.RECEIPT_LINES_DELIMITER;

/**
 * Assumption: one
 */
public class Order {
    private final List<Purchasable> items;
    private final BeverageStamp beverageStamp;

    public Order(final List<Purchasable> items) {
        this(items, BeverageStamp.ZERO);
    }

    public Order(final List<Purchasable> items, final BeverageStamp beverageStamp) {
        this.items = Objects.requireNonNull(items);
        this.beverageStamp = beverageStamp == null ? BeverageStamp.ZERO : beverageStamp;
    }

    public List<Purchasable> getItems() {
        return items;
    }

    public BeverageStamp getBeverageStamp() {
        return beverageStamp;
    }

    public double getTotalPrice() {
        return this.items.stream().mapToDouble(Purchasable::getTotalPrice).sum();
    }

    public String toSummaryString() {
        return "=== ORDER ========================\n" +
                "Stamps: " +
                this.beverageStamp.getStampCount() +
                (this.items.size() > 0 ? "\n" : "") +
                this.items.stream()
                        .map(Purchasable::getReceiptLines)
                        .collect(Collectors.joining(RECEIPT_LINES_DELIMITER)) +
                "\n==================================";
    }
}
