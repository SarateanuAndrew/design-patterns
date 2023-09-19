package creational.company;

public class CompanyDepartment {
    private static CompanyDepartment companyDepartment;
    private String name;

    private CompanyDepartment() {
    }

    public static CompanyDepartment getInstance() {
        if (companyDepartment == null) {
            companyDepartment = new CompanyDepartment();
        }
        return companyDepartment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
