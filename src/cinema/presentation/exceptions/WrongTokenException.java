package cinema.presentation.exceptions;

public class WrongTokenException {
    private final String error;

    public WrongTokenException() {
        this.error = "Wrong token!";
    }

    public String getError() {
        return error;
    }
}
