package coffee.charlene.ch;

import java.util.List;
import java.util.stream.Collectors;

import static coffee.charlene.ch.Purchasable.RECEIPT_LINES_DELIMITER;

public class Receipt {
    private final Order order;
    private final BeverageStamp beverageStamp;

    public Receipt(final Order order, final BeverageStamp beverageStamp) {
        this.order = order;
        this.beverageStamp = beverageStamp;
    }

    public Order getOrder() {
        return order;
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
                String.format("\nTOTAL: %.2f CHF", this.getTotalPrice()) +
                "\nNew Stamps: " +
                this.getBeverageStamp().getStampCount() +
                "\n====================================";
    }

    public double getTotalPrice() {
        return this.order.getTotalPrice();
    }
}
