package structural.decorator;

public class CarDecorator implements Car {
    protected Car car;

    public CarDecorator(Car c) {
        this.car = c;
    }

    @Override
    public void drive() {
        System.out.println("Drive on road");
    }

    @Override
    public int finalPrice() {
        return this.car.finalPrice();
    }

}
