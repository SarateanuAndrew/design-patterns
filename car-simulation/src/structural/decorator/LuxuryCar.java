package structural.decorator;

public class LuxuryCar extends CarDecorator {

    private int addPrice;

    public LuxuryCar(Car c, int addPrice) {
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
    public int finalPrice(){
        return super.finalPrice() + getAddPrice();
    }
}
