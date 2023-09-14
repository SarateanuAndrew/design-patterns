package structural.bridge;

public abstract class TractorAccessoryBridge {
    protected TractorAccessory tractorAccessory;

    public TractorAccessoryBridge(TractorAccessory tractorAccessory){
        this.tractorAccessory = tractorAccessory;
    }

    abstract public int additionPrice();
}
