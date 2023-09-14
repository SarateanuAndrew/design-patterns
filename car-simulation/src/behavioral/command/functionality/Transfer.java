package behavioral.command.functionality;

import behavioral.command.cards.CardFunctionality;

public class Transfer implements Command {

    private CardFunctionality cardFunctionality;

    public Transfer(CardFunctionality fs){
        this.cardFunctionality =fs;
    }
    @Override
    public String execute() {
        return this.cardFunctionality.cardPayments();
    }

}
