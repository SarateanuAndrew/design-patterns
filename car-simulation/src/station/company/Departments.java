package station.company;

public abstract class Departments implements Company, CompanyStaffCount{
    private int price;
    private int staff;
    private SecondaryCompany secondaryCompany;
    public Departments(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void countStaff() {
        System.out.println(staff);
    }
}
