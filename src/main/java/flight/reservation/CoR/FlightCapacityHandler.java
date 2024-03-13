package flight.reservation.CoR;
import flight.reservation.Customer;
import flight.reservation.flight.ScheduledFlight;

import java.util.List;

public class FlightCapacityHandler implements OrderValidationHandler {

    @Override
    public boolean handleValidation(Customer customer, List<String> passengerNames, List<ScheduledFlight> flights) {
        return flights.stream().allMatch(scheduledFlight -> {
            try {
                return scheduledFlight.getAvailableCapacity() >= passengerNames.size();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
                return false;
            }
        });
    }
}