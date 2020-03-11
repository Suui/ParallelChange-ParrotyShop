public class FakeNotificationService implements NotificationService {

    @Override
    public void sendSuccessfulPurchaseEmail(String email, String message) {
        System.out.println("sent to: " + email + ", message: " + message);
    }
}
