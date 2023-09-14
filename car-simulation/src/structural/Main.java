package structural;

import structural.adapter.CarAdapter;
import structural.adapter.Tractor;
import structural.adapter.TractorFunctionality;
import structural.bridge.*;
import structural.composite.MonsterSticker;
import structural.composite.StickerInstaller;
import structural.composite.CarSticker;
import structural.composite.GirlSticker;
import structural.decorator.BasicCar;
import structural.decorator.Car;
import structural.decorator.LuxuryCar;
import structural.decorator.SportsCar;

public class Main {
    public static void main(String[] args) {
        //Bridge
        TractorAccessoryBridge sweeper = new Sweeper(new TitanTractorAccessory(), 100);
        sweeper.additionPrice();

        TractorAccessoryBridge aerator = new Aerator(new SteelTractorAccessory(), 200);
        aerator.additionPrice();

        //Composite
        CarSticker square1 = new GirlSticker();
        CarSticker square2 = new GirlSticker();
        CarSticker cir = new MonsterSticker();

        StickerInstaller stickerInstaller = new StickerInstaller(100);
        stickerInstaller.add(square2);
        stickerInstaller.add(square2);
        stickerInstaller.add(cir);

        stickerInstaller.install("Red");

        stickerInstaller.clear();

        stickerInstaller.add(square1);
        stickerInstaller.add(cir);
        stickerInstaller.install("Green");


//        Decorator
        Car sportsCar = new SportsCar(new BasicCar("Scoda", 10000, stickerInstaller), 1000);
        System.out.println(sportsCar.finalPrice());

        Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar("Mercedes", 40000, stickerInstaller), 10000), 10000);
        System.out.println(sportsLuxuryCar.finalPrice());


//        Adapter
        TractorFunctionality tractorFunctionality = new Tractor(aerator, 1200000);
        TractorFunctionality carAdapter = new CarAdapter(sportsCar);
        System.out.println(tractorFunctionality.displayFinalPrice());
        carAdapter.workOnField();
    }
}
