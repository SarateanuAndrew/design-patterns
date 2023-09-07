package station.company;

public class FoodMarket extends DesignDepartment{
    private int capacity;
    public FoodMarket(int price) {
        super(price);
    }
    @Override
    public void displayDepartmentName() {
        System.out.println("Food");
    }
}
