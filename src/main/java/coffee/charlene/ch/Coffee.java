package coffee.charlene.ch;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Coffee extends AbstractProduct implements Drinkable {

    private static final String PADDING = "   ";

    private final CoffeeSize size;
    private final List<CoffeeAddable> extras;

    public Coffee(final CoffeeSize size) {
        this(size, Collections.emptyList());
    }

    public Coffee(final CoffeeSize size, final List<CoffeeAddable> extras) {
        super(size.getPrice());
        this.size = size;
        this.extras = Objects.requireNonNull(extras);
    }

    @Override
    public String getReceiptLines() {
        if (extras.size() == 0) {
            return Drinkable.super.getReceiptLines();
        }
        final String extraLines = this.extras.stream()
                .map(e -> PADDING + e.getReceiptLines())
                .collect(Collectors.joining(RECEIPT_LINES_DELIMITER));
        return String.join(RECEIPT_LINES_DELIMITER, List.of(Drinkable.super.getReceiptLines(), extraLines));
    }

    @Override
    public String getProductName() {
        return String.format("Coffee (%s)", this.size.name().toLowerCase());
    }

    @Override
    public double getTotalPrice() {
        return this.getPrice() + this.extras.stream().mapToDouble(Purchasable::getTotalPrice).sum();
    }
}
