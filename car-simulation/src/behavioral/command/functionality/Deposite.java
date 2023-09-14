package behavioral.command.functionality;

import behavioral.command.cards.CardFunctionality;

public class Deposite implements Command {

    private CardFunctionality cardFunctionality;

    public Deposite(CardFunctionality fs){
        this.cardFunctionality =fs;
    }
    @Override
    public String execute() {
       return this.cardFunctionality.cardTransfer();
    }

}