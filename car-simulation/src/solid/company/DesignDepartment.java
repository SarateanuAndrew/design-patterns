package solid.company;

public class DesignDepartment extends Department {
    public DesignDepartment(int price, int staff, SecondaryCompany secondaryCompany) {
        super(price, staff, secondaryCompany);
    }

    public DesignDepartment(int price) {
        super(price);
    }

    @Override
    public void displayDepartmentName() {
        System.out.println("Design");
    }
}
