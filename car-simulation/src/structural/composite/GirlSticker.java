package structural.composite;

public class GirlSticker implements CarSticker {

    @Override
    public void install(String fillColor) {
        System.out.println("A girl sticker with color " + fillColor + " was installed");
    }

}
