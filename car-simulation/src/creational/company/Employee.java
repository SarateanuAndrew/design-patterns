package creational.company;

import creational.obligations.Obligation;

import java.util.ArrayList;
import java.util.List;

public class Employee implements Cloneable {
    private List<String> obligations;
    private String fullName;
    private int salary;
    private CompanyDepartment department;

    public Employee(EmployeeBuilder builder) {
        this.obligations = builder.obligations;
        this.fullName = builder.fullName;
        this.salary = builder.salary;
        this.department = builder.department;
    }

    public void saveObligation(Obligation obligation) {
        obligations.add(obligation.employeeObligation());
    }

    public void deleteObligation(Obligation obligation) {
        obligations.remove(obligation.employeeObligation());
    }

    public List<String> getObligations() {
        return obligations;
    }

    public String getFullName() {
        return fullName;
    }

    public CompanyDepartment getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object clone = super.clone();
        List<String> tempOblig = new ArrayList<String>(this.getObligations());
        String tempFullName = this.getFullName();
        int tempSalary = this.getSalary();
        CompanyDepartment tempDepartment = this.getDepartment();
        return new EmployeeBuilder()
                .setSalary(tempSalary)
                .setDepartment(tempDepartment)
                .setObligations(tempOblig)
                .setFullName(tempFullName)
                .build();
    }

    public static class EmployeeBuilder {
        private List<String> obligations;
        private String fullName;
        private int salary;
        private CompanyDepartment department;

        public EmployeeBuilder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public EmployeeBuilder setSalary(int salary) {
            this.salary = salary;
            return this;
        }

        public EmployeeBuilder setObligations(List<String> obligations) {
            this.obligations = obligations;
            return this;
        }

        public EmployeeBuilder setDepartment(CompanyDepartment department) {
            this.department = department;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}
