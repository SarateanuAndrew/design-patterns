package structural.composite;

import java.util.ArrayList;
import java.util.List;

public class StickerInstaller implements CarSticker {
    private int price;

    public StickerInstaller(int price) {
        this.price = price;
    }

    private List<CarSticker> carStickers = new ArrayList<>();

    @Override
    public void install(String fillColor) {
        for(CarSticker sh : carStickers)
        {
            sh.install(fillColor);
        }
    }

    public void add(CarSticker s){
        this.carStickers.add(s);
    }

    //removing shape from drawing
    public void remove(CarSticker s){
        carStickers.remove(s);
    }

    public int getPrice() {
        return price * carStickers.size();
    }

    public void setPrice(int price) {
        this.price = price;
    }

    //removing all the shapes
    public void clear(){
        System.out.println("Uninstalling all stickers from car");
        this.carStickers.clear();
    }
}
