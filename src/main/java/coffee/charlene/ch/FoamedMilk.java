package coffee.charlene.ch;

public class FoamedMilk implements CoffeeAddable {

    private double price = 0.5;

    @Override
    public String getProductName() {
        return "Foamed milk";
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }
}
