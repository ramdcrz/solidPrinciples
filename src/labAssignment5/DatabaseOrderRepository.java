package labAssignment5;

public class DatabaseOrderRepository implements OrderRepository {
    @Override
    public void placeOrder(Order order) {
        System.out.println("Order placed for " + order.getCustomerName() + " at " + order.getAddress());
    }
}