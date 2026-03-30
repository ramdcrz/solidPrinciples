package labAssignment5;

public class OrderTest {
    public static void main(String[] args) {
        Order myOrder = new Order("John Doe", "123 Main St", 10.0, 2);

        OrderRepository repo = new DatabaseOrderRepository();
        InvoiceGenerator invoiceGen = new PdfInvoiceGenerator();
        NotificationSender emailSender = new EmailNotificationSender();

        OrderProcessor processor = new OrderProcessor(repo, invoiceGen, emailSender);
        processor.process(myOrder, "order_123.pdf", "johndoe@example.com");
    }
}
