package cinema.presentation.exceptions;

public class SeatOutOfBoundsException {
    private final String error;

    public SeatOutOfBoundsException() {
        this.error = "The number of a row or a column is out of bounds!";
    }

    public String getError() {
        return error;
    }
}
