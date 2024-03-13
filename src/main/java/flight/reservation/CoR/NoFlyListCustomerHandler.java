package flight.reservation.CoR;
import flight.reservation.Customer;
import flight.reservation.flight.ScheduledFlight;
import flight.reservation.order.FlightOrder;

import java.util.List;

public class NoFlyListCustomerHandler implements OrderValidationHandler {

    private final OrderValidationHandler nextHandler;

    public NoFlyListCustomerHandler(OrderValidationHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public boolean handleValidation(Customer customer, List<String> passengerNames, List<ScheduledFlight> flights) {
        if (FlightOrder.getNoFlyList().contains(customer.getName())) {
            return false; // Validation failed
        }
        return nextHandler.handleValidation(customer, passengerNames, flights); // Pass to next handler
    }
}