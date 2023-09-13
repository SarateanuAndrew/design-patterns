package creational.obligations;

public class ObligationFactory {
    public Obligation createObligation(String obligation)
    {
        if (obligation == null || obligation.isEmpty())
            return null;
        return switch (obligation) {
            case "B" -> new BackObligation();
            case "D" -> new DesignObligation();
            case "F" -> new FrontObligation();
            default -> throw new IllegalArgumentException("Unknown obligation " + obligation);
        };
    }
}
