package coffee.charlene.ch;

public class FoamedMilk implements CoffeeAddable {

    @Override
    public String getProductName() {
        return "Foamed milk";
    }

    @Override
    public double getPrice() {
        return 0.5;
    }
}
