package structural.bridge;

public class Aerator extends TractorAccessoryBridge {
    private int price;
    public Aerator(TractorAccessory c, int price) {
        super(c);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int additionPrice() {
        return tractorAccessory.additionPrice() + price;
    }

}