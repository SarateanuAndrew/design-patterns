package station.company;

public class SecondaryCompanyShow implements SecondaryCompany {
    private String companyName;

    public SecondaryCompanyShow(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public void displaySecondaryCompanyName(String name) {
        System.out.println(name);
    }
}
