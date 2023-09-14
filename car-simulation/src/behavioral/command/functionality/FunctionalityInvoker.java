package behavioral.command.functionality;

public class FunctionalityInvoker {

    public Command command;

    public FunctionalityInvoker(Command c) {
        this.command = c;
    }

    public String execute() {
        return this.command.execute();
    }
}
