package station.company;

public class DesignDepartment extends Departments{
    public DesignDepartment(int price) {
        super(price);
    }

    @Override
    public void displayDepartmentName() {
        System.out.println("Design");
    }
}
