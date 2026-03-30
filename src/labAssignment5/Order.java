package labAssignment5;

public class Order {
    private double price;
    private int quantity;
    private String customerName;
    private String address;

    public Order(String customerName, String address, double price, int quantity) {
        this.customerName = customerName;
        this.address = address;
        this.price = price;
        this.quantity = quantity;
    }

    public double calculateTotal() {
        return price * quantity;
    }

    // Getters
    public String getCustomerName() { return customerName; }
    public String getAddress() { return address; }
}