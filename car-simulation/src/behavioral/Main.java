package behavioral;

import behavioral.command.CardTypeDeterminerUtil;
import behavioral.command.cards.CardFunctionality;
import behavioral.command.cards.CreditCardStrategy;
import behavioral.command.cards.PaypalStrategy;
import behavioral.command.functionality.*;
import behavioral.iterator.ItemBar;
import behavioral.iterator.ItemCollection;
import behavioral.observer.CardUsage;
import behavioral.observer.CardUsageSubscriber;
import behavioral.observer.Observer;
import behavioral.strategy.Item;
import behavioral.strategy.ShoppingCart;

public class Main {
    public static void main(String[] args) {
        //Strategy
        ShoppingCart cart = new ShoppingCart();

        Item item1 = new Item("1234", 10);
        Item item2 = new Item("5678", 40);

        cart.addItem(item1);
        cart.addItem(item2);

        //pay by paypal
        cart.pay(new PaypalStrategy("myemail@example.com", "mypwd"));

        //pay by credit card
        cart.pay(new CreditCardStrategy("Pankaj Kumar", "1234567890123456", "786", "12/15"));

        //Iterator
        ItemCollection nc = new ItemCollection();
        nc.addItem("asd", 43);
        nc.addItem("rew", 53);
        ItemBar nb = new ItemBar(nc);
        nb.printItemsPrices();

        //Command
        //Creating the receiver object
        CreditCardStrategy creditCardStrategy = new CreditCardStrategy();
        PaypalStrategy paypalStrategy = new PaypalStrategy();
        CardFunctionality creditCard = CardTypeDeterminerUtil.getCardType(creditCardStrategy);
        CardFunctionality paypalCard = CardTypeDeterminerUtil.getCardType(paypalStrategy);

        //creating command and associating with receiver
        Command transfer = new Transfer(creditCard);

        //Creating invoker and associating with Command
        FunctionalityInvoker invoker = new FunctionalityInvoker(transfer);

        //perform action on invoker object
        String transferInvoker = invoker.execute();

        Command deposite = new Deposite(creditCard);
        invoker = new FunctionalityInvoker(deposite);
        String depositInvoker = invoker.execute();

        Command payment = new Payment(paypalCard);
        invoker = new FunctionalityInvoker(payment);
        String paymentInvoker = invoker.execute();

        //Observer
        //create subject
        CardUsage creditCardUsage = new CardUsage();
        CardUsage paypalUsage = new CardUsage();

        //create observers
        Observer creditCardObserver = new CardUsageSubscriber("Credit Card observer ");
        Observer paypalObserver = new CardUsageSubscriber("Paypal Observer ");


        //register observers to the subject
        creditCardUsage.register(creditCardObserver);
        paypalUsage.register(paypalObserver);


        //attach observer to subject
        creditCardObserver.setSubject(creditCardUsage);
        paypalObserver.setSubject(paypalUsage);

        //check if any update is available
        creditCardObserver.update();
        paypalObserver.update();

        //now send message to subject
        creditCardUsage.postMessage(transferInvoker);
        paypalUsage.postMessage(paymentInvoker);
    }
}

