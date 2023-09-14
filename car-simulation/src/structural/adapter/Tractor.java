package structural.adapter;

import structural.bridge.TractorAccessory;
import structural.bridge.TractorAccessoryBridge;

public class Tractor implements TractorFunctionality {
    private TractorAccessoryBridge tractorAccessoryBridge;
    private int price;

    public Tractor(TractorAccessoryBridge tractorAccessoryBridge, int price) {
        this.tractorAccessoryBridge = tractorAccessoryBridge;
        this.price = price;
    }


    public void workOnField() {
        System.out.println("Work on field");
    }

    @Override
    public int displayFinalPrice() {
        return price + tractorAccessoryBridge.additionPrice();
    }
}
