package solid.company;

public class Washing extends Department {
    public Washing(int price, int staff, SecondaryCompany secondaryCompany) {
        super(price, staff, secondaryCompany);
    }

    public Washing(int price) {
        super(price);
    }

    @Override
    public void displayDepartmentName() {
        System.out.println("Wash");
    }
}
