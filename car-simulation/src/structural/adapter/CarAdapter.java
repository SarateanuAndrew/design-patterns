package structural.adapter;

import structural.decorator.Car;

public class CarAdapter implements TractorFunctionality {
    Car car;
    public CarAdapter(Car car) {
        this.car = car;
    }

    public void workOnField()
    {
        car.drive();
    }

    @Override
    public int displayFinalPrice() {
        return car.finalPrice();
    }
}
