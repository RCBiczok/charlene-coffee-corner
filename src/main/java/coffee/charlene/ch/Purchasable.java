package coffee.charlene.ch;

/**
 * Represents any kind of purchasable product.
 */
public interface Purchasable {

    String RECEIPT_LINES_DELIMITER = "\n";

    /**
     * Assumption: receipt can be multi-line, as it might have additional components (extras)
     * @return the receipt lines for the receipt separated by '\n'
     */
    default String getReceiptLines() {
        return String.format("- %s %.2f CHF", this.getProductName(), this.getPrice());
    }

    String getProductName();

    /**
     * Assumption: Prices have precision of 2 and fit and don't exceed MAX_DOUBLE if added up together.
     * @return the price for this article
     */
    double getPrice();

    /**
     * Updates the price to reflect discounts
     */
    void setPrice(final double price);

    /**
     * @return the price including all extras
     */
    default double getTotalPrice() {
        return this.getPrice();
    }
}
