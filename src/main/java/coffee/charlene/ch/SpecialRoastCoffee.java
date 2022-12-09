package coffee.charlene.ch;

public class SpecialRoastCoffee implements CoffeeAddable {
    @Override
    public String getProductName() {
        return "Special roast coffee";
    }

    @Override
    public double getPrice() {
        return 0.9;
    }
}
