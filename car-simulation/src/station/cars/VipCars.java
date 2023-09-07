package station.cars;

public class VipCars extends GoodCar {
    private int tuning;

    public VipCars() {
    }

    public VipCars(int food, int fuel, int repair, int clean, int tuning, int money, int bacshis, boolean discount) {
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
