package station.company;

public class Washing extends Departments{
    public Washing(int price) {
        super(price);
    }
    @Override
    public void displayDepartmentName() {
        System.out.println("Wash");
    }
}
