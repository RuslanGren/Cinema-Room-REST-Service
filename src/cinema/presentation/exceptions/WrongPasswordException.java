package cinema.presentation.exceptions;

public class WrongPasswordException {
    private final String error;

    public WrongPasswordException() {
        this.error = "The password is wrong!";
    }

    public String getError() {
        return error;
    }
}
