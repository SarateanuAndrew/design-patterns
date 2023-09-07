package station.company;

public class MechanicalDepartment extends Department {
        private int pieces;

        public MechanicalDepartment(int price, int staff, SecondaryCompany secondaryCompany, int pieces) {
                super(price, staff, secondaryCompany);
                this.pieces = pieces;
        }

        public MechanicalDepartment(int price) {
                super(price);
        }

        @Override
        public void displayDepartmentName() {
                System.out.println("Mechanical");
        }
}
