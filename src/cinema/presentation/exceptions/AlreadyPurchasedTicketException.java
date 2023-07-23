package cinema.presentation.exceptions;

public class AlreadyPurchasedTicketException {
    private final String error;

    public AlreadyPurchasedTicketException() {
        this.error = "The ticket has been already purchased!";
    }

    public String getError() {
        return error;
    }
}
