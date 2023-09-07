package station.company;

public class GasStation extends Department {
    private int fuel;

    public GasStation(int price, int staff, SecondaryCompany secondaryCompany, int fuel) {
        super(price, staff, secondaryCompany);
        this.fuel = fuel;
    }

    public GasStation(int price) {
        super(price);
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }

    @Override
    public void setPrice(int price) {
        super.setPrice(price);
    }
    @Override
    public void displayDepartmentName() {
        System.out.println("Gas");
    }
}
