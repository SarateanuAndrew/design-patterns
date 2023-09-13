package solid.cars;

public class StandardCar {
    private int food;
    private int fuel;
    private int repair;
    private int clean;
    private int money;

    public StandardCar() {
    }

    public StandardCar(int food, int fuel, int repair, int clean, int money) {
        this.food = food;
        this.fuel = fuel;
        this.repair = repair;
        this.clean = clean;
        this.money = money;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getRepair() {
        return repair;
    }

    public void setRepair(int repair) {
        this.repair = repair;
    }

    public int getClean() {
        return clean;
    }

    public void setClean(int clean) {
        this.clean = clean;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return "StandardCar";
    }

    public String service() {
        int sum = getClean() + getFood() + getFuel() + getRepair();
        if (sum == 4) {
            return "Is Happy";
        } else if (sum == 3) {
            return "Is good";
        } else if (sum == 2) {
            return "Is normal";
        } else if (sum == 1) {
            return "Is moody";
        } else {
            return "Is sad";
        }
    }
}