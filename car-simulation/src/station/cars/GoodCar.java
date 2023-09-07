package station.cars;

public class GoodCar extends StandardCar {
    private int bacshis;
    private boolean discount;

    public GoodCar() {
    }

    public GoodCar(int food, int fuel, int repair, int clean, int money, int bacshis, boolean discount) {
        super(food, fuel, repair, clean, money);
        this.bacshis = bacshis;
        this.discount = discount;
    }

    public int getBacshis() {
        return bacshis;
    }

    public void setBacshis(int bacshis) {
        this.bacshis = bacshis;
    }

    public String getName() {
        return "GoodCar";
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }
}
