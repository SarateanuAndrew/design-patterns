package structural.composite;

public class MonsterSticker implements CarSticker {
    private int price;
    @Override
    public void install(String fillColor) {
        System.out.println("Monster Sticker with color " + fillColor + " was installed");
    }

}
