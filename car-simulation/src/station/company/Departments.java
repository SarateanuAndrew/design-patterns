package station.company;

public abstract class Departments implements Company, CompanyStaffCount {
    private int price;
    private int staff;
    private SecondaryCompany secondaryCompany;

    public Departments(int price, int staff, SecondaryCompany secondaryCompany) {
        this.price = price;
        this.staff = staff;
        this.secondaryCompany = secondaryCompany;
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

    public SecondaryCompany getSecondaryCompany() {
        return secondaryCompany;
    }

    public int getStaff() {
        return staff;
    }

    public void setStaff(int staff) {
        this.staff = staff;
    }

    public void setSecondaryCompany(SecondaryCompany secondaryCompany) {
        this.secondaryCompany = secondaryCompany;
    }
}
