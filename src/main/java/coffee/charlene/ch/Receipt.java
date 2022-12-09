package coffee.charlene.ch;

import java.util.List;
import java.util.stream.Collectors;

import static coffee.charlene.ch.Purchasable.RECEIPT_LINES_DELIMITER;

public class Receipt {
    private final Order order;
    private final List<? extends Purchasable> deductedItems;
    private final BeverageStamp beverageStamp;

    public Receipt(final Order order, final List<? extends Purchasable> deductedItems, final BeverageStamp beverageStamp) {
        this.order = order;
        this.deductedItems = deductedItems;
        this.beverageStamp = beverageStamp;
    }

    public Order getOrder() {
        return order;
    }

    public List<? extends Purchasable> getDeductedItems() {
        return deductedItems;
    }

    public BeverageStamp getBeverageStamp() {
        return beverageStamp;
    }

    public String toSummaryString() {
        return "=== RECEIPT ========================\n" +
                "Stamps: " +
                this.order.getBeverageStamp().getStampCount() +
                "\n" +
                "Items: " +
                (this.order.getItems().size() > 0 ? "\n" : "") +
                this.order.getItems().stream()
                        .map(Purchasable::getReceiptLines)
                        .collect(Collectors.joining(RECEIPT_LINES_DELIMITER)) +
                "\nDeducted items: " +
                (this.getDeductedItems().size() > 0 ? "\n" : "") +
                this.getDeductedItems().stream()
                        .map(Purchasable::getReceiptLines)
                        .collect(Collectors.joining(RECEIPT_LINES_DELIMITER)) +
                String.format("\nTOTAL: %.2f CHF", this.getTotalPrice()) +
                "\nNew Stamps: " +
                this.getBeverageStamp().getStampCount() +
                "\n====================================";
    }

    public double getTotalPrice() {
        return this.order.getItems().stream().mapToDouble(Purchasable::getTotalPrice).sum()
                - this.deductedItems.stream().mapToDouble(Purchasable::getTotalPrice).sum();
    }
}
