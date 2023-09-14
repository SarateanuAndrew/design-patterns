package behavioral.observer;

public class CardUsageSubscriber implements Observer {

    private String name;
    private Usage usage;

    public CardUsageSubscriber(String nm) {
        this.name = nm;
    }

    @Override
    public void update() {
        String msg = (String) usage.getUpdate(this);
        if (msg == null) {
            System.out.println(name + ":: No new message");
        } else
            System.out.println(name + ":: Consuming message::" + msg);
    }

    @Override
    public void setSubject(Usage sub) {
        this.usage = sub;
    }

}