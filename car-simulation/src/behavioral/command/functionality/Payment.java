package behavioral.command.functionality;

import behavioral.command.cards.CardFunctionality;

public class Payment implements Command {

    private CardFunctionality cardFunctionality;

    public Payment(CardFunctionality fs){
        this.cardFunctionality =fs;
    }
    @Override
    public String execute() {
        return this.cardFunctionality.cardDeposit();
    }

}