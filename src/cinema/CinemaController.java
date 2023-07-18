package cinema;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class CinemaController {

    @GetMapping("/seats")
    public String getSeats(AvailableSeats availableSeats) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(availableSeats);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
