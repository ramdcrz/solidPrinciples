package labAssignment5;

public class EmailNotificationSender implements NotificationSender {
    @Override
    public void sendNotification(String email) {
        System.out.println("Email notification sent to: " + email);
    }
}