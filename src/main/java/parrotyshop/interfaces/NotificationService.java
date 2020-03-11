package parrotyshop.interfaces;

public interface NotificationService {
    void sendSuccessfulPurchaseEmail(String email, String message);

    void notifySale(String saleInfo);
}
