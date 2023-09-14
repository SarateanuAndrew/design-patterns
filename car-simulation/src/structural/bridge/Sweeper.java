package structural.bridge;

public class Sweeper extends TractorAccessoryBridge {

    public Sweeper(TractorAccessory c, int price) {
        super(c);
        this.price = price;
    }

    private int price;

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