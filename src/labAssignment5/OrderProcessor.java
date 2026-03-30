package labAssignment5;

public class OrderProcessor {
    private final OrderRepository repository;
    private final InvoiceGenerator invoiceGenerator;
    private final NotificationSender notificationSender;

    // We inject the dependencies through the constructor.
    // Notice that InvoiceGenerator and NotificationSender can be null if not needed!
    public OrderProcessor(OrderRepository repository, 
                          InvoiceGenerator invoiceGenerator, 
                          NotificationSender notificationSender) {
        this.repository = repository;
        this.invoiceGenerator = invoiceGenerator;
        this.notificationSender = notificationSender;
    }

    public void process(Order order, String invoiceFileName, String contactEmail) {
        System.out.println("Order total: $" + order.calculateTotal());
        repository.placeOrder(order);

        if (invoiceGenerator != null && invoiceFileName != null) {
            invoiceGenerator.generateInvoice(invoiceFileName);
        }

        if (notificationSender != null && contactEmail != null) {
            notificationSender.sendNotification(contactEmail);
        }
    }
}