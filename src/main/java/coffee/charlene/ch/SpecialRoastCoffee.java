package coffee.charlene.ch;

public class SpecialRoastCoffee extends AbstractProduct implements CoffeeAddable {
    public SpecialRoastCoffee() {
        super(0.9);
    }

    @Override
    public String getProductName() {
        return "Special roast coffee";
    }

}
