package behavioral.command.cards;

import behavioral.observer.Observer;
import behavioral.strategy.PaymentStrategy;

public class CreditCardStrategy implements PaymentStrategy, CardFunctionality {

    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    public CreditCardStrategy(String nm, String ccNum, String cvv, String expiryDate){
        this.name=nm;
        this.cardNumber=ccNum;
        this.cvv=cvv;
        this.dateOfExpiry=expiryDate;
    }

    public CreditCardStrategy() {
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount +" paid with credit/debit card");
    }

    @Override
    public String cardTransfer() {
        return "Transfer from CreditCard";
    }

    @Override
    public String cardDeposit() {
        return "CreditCard deposit creation";
    }

    @Override
    public String cardPayments() {
        return "CreditCard Payment process";
    }
}
