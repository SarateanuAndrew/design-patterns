package behavioral.command;

import behavioral.command.cards.CardFunctionality;
import behavioral.command.cards.CreditCardStrategy;
import behavioral.command.cards.PaypalStrategy;

public class CardTypeDeterminerUtil {

    public static CardFunctionality getCardType(CardFunctionality cardFunctionality) {
        if (cardFunctionality.getClass().equals(CreditCardStrategy.class)) {
            return new CreditCardStrategy();
        } else {
            return new PaypalStrategy();
        }
    }

}