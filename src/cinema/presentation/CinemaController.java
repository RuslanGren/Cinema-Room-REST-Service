package cinema.presentation;

import cinema.businesslayer.*;
import cinema.presentation.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
public class CinemaController {
    private final Cinema cinema = new Cinema(9, 9);

    @GetMapping("/seats")
    public Cinema getSeats() {
        return cinema;
    }

    @GetMapping("/stats")
    public ResponseEntity<?> getStats(@RequestParam(value = "password", required = false) String password) {
        if (password == null || !password.equals("super_secret")) {
            return new ResponseEntity<>(new WrongPasswordException(), HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(cinema.getStatistics(), HttpStatus.OK);
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> purchaseTicket(@RequestBody Seat inputSeat) {
        for (Seat seat : cinema.getAvailableSeats()) {
            if (seat.hashCode() == inputSeat.hashCode()) {
                if (seat.isPurchased()) {
                    return new ResponseEntity<>(new AlreadyPurchasedTicketException(), HttpStatus.BAD_REQUEST);
                } else {
                    Ticket ticket = new Ticket(UUID.randomUUID(), seat);
                    cinema.purchaseTicket(ticket);
                    return new ResponseEntity<>(ticket, HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>(new SeatOutOfBoundsException(), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/return")
    public ResponseEntity<?> returnTicket(@RequestBody Map<String, UUID> request) {
        UUID token = request.get("token");
        for (Ticket ticket : cinema.getPurchasedTickets()) {
            if (ticket.getToken().equals(token)) {
                cinema.returnTicket(ticket);
                return new ResponseEntity<>(Map.of("returned_ticket", ticket.getSeat()), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(new WrongTokenException(), HttpStatus.BAD_REQUEST);
    }

}