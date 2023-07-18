package cinema;

import java.util.ArrayList;
import java.util.List;

public class AvailableSeats {
    private int total_rows = 9;
    private int total_columns = 9;
    private List<Seat> available_seats;

    public AvailableSeats() {
        this.available_seats = new ArrayList<>();

        for (int i = 0; i < total_rows; i++) {
            for (int j = 0; j < total_columns; j++) {
                available_seats.add(new Seat(i + 1, j + 1));
            }
        }

    }

    public int getTotal_rows() {
        return total_rows;
    }

    public void setTotal_rows(int total_rows) {
        this.total_rows = total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public void setTotal_columns(int total_columns) {
        this.total_columns = total_columns;
    }

    public List<Seat> getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats(List<Seat> available_seats) {
        this.available_seats = available_seats;
    }
}
