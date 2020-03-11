package parrotyshop;

import parrotyshop.interfaces.NotificationService;

public class FakeNotificationService implements NotificationService {

    @Override
    public void sendSuccessfulPurchaseEmail(String email, String message) {
        System.out.println("sent to: " + email + ", message: " + message);
    }

    @Override
    public void notifySale(String saleInfo) {
        System.out.println(saleInfo);
    }
}
