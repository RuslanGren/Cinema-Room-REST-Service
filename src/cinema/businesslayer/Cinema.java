package cinema.businesslayer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    @JsonProperty("available_seats")
    private final List<Seat> availableSeats = new ArrayList<>();
    @JsonIgnore
    private final List<Ticket> purchasedTickets = new ArrayList<>();
    private int total_rows;
    private int total_columns;
    @JsonIgnore
    private Statistics statistics;

    public Cinema(int total_rows, int total_columns) {
        this.total_rows = total_rows;
        this.total_columns = total_columns;

        for (int row = 1; row <= total_rows; row++) {
            for (int column = 1; column <= total_columns; column++) {
                availableSeats.add(new Seat(row, column));
            }
        }

        statistics = new Statistics(total_columns * total_rows);

    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }

    public List<Ticket> getPurchasedTickets() {
        return purchasedTickets;
    }

    public void purchaseTicket(Ticket ticket) {
        purchasedTickets.add(ticket);
        ticket.getSeat().setPurchased(true);
        statistics.purchaseTicket(ticket.getSeat().getPrice());
    }

    public void returnTicket(Ticket ticket) {
        purchasedTickets.remove(ticket);
        ticket.getSeat().setPurchased(false);
        statistics.returnTicket(ticket.getSeat().getPrice());
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
}
