package station.company;

public class MechanicalDepartment extends Departments{
        private int pieces;
        public MechanicalDepartment(int price) {
                super(price);
        }
        @Override
        public void displayDepartmentName() {
                System.out.println("Mechanical");
        }
}
