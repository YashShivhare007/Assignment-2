package flight.reservation.CoR;
import flight.reservation.Customer;
import flight.reservation.flight.ScheduledFlight;

import java.util.List;

public interface OrderValidationHandler {
    boolean handleValidation(Customer customer, List<String> passengerNames, List<ScheduledFlight> flights);
}