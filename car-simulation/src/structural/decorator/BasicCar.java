package structural.decorator;

import structural.composite.StickerInstaller;

public class BasicCar implements Car {
    private String model;
    private int price;
    private StickerInstaller stickerInstaller;

    public BasicCar(String model, int price, StickerInstaller stickerInstaller) {
        this.model = model;
        this.price = price;
        this.stickerInstaller = stickerInstaller;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int finalPrice() {
        return getPrice() + stickerInstaller.getPrice();
    }

    @Override
    public void drive() {
        System.out.println("Drive on road");
    }
}
