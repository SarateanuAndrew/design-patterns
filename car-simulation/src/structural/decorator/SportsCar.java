package structural.decorator;

public class SportsCar extends CarDecorator {
    private int addPrice;

    public SportsCar(Car c, int addPrice) {
        super(c);
        this.addPrice = addPrice;
    }

    public int getAddPrice() {
        return addPrice;
    }

    public void setAddPrice(int addPrice) {
        this.addPrice = addPrice;
    }

    @Override
    public int finalPrice() {
        return super.finalPrice() + getAddPrice();
    }
}
