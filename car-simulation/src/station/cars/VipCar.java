package station.cars;

public class VipCar extends GoodCar {
    private int tuning;

    public VipCar() {
    }

    public VipCar(int food, int fuel, int repair, int clean, int tuning, int money, int bacshis, boolean discount) {
        super(food, fuel, repair, clean, money, bacshis, discount);
        this.tuning = tuning;
    }

    public int getTuning() {
        return tuning;
    }

    public void setTuning(int tuning) {
        this.tuning = tuning;
    }
}
