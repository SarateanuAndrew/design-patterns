package creational;

import creational.company.CompanyDepartment;
import creational.company.Employee;
import creational.obligations.Obligation;
import creational.obligations.ObligationFactory;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        CompanyDepartment department = CompanyDepartment.getInstance();
        department.setName("Engine");
        CompanyDepartment department1 = CompanyDepartment.getInstance();
        System.out.println("Department name is " + department1.getName());
        Employee emp1 = new Employee.EmployeeBuilder()
                .setObligations(new ArrayList<>())
                .setSalary(1200)
                .setDepartment(department)
                .setFullName("Vasea")
                .build();

        ObligationFactory obligationFactory = new ObligationFactory();
        Obligation back = obligationFactory.createObligation("B");
        Obligation front = obligationFactory.createObligation("F");
        Obligation design = obligationFactory.createObligation("D");
        emp1.saveObligation(back);
        emp1.saveObligation(front);

        Employee emp2 = (Employee) emp1.clone();
        Employee emp3 = (Employee) emp1.clone();
        emp3.saveObligation(design);
        Employee emp4 = (Employee) emp1.clone();
        emp4.deleteObligation(back);

        System.out.println(emp2.getObligations());
        System.out.println(emp3.getObligations());
        System.out.println(emp4.getObligations());
    }
}
