package behavioral.command.cards;

import behavioral.strategy.PaymentStrategy;

public class PaypalStrategy implements PaymentStrategy, CardFunctionality {

    private String emailId;
    private String password;

    public PaypalStrategy() {
    }

    public PaypalStrategy(String email, String pwd) {
        this.emailId = email;
        this.password = pwd;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using Paypal.");
    }

    @Override
    public String cardTransfer() {
        return "Transfer from Paypal";
    }

    @Override
    public String cardDeposit() {
        return "Paypal deposit creation";
    }

    @Override
    public String cardPayments() {
        return "Paypal Payment process";
    }
}
