import parrotyshop.*;

public class ParrotyShop {

    public static void main(String[] args) {
        System.out.println("First purchase: ");
        firstPurchase();

        System.out.println("\nSecond purchase:");
        secondPurchase();

        System.out.println("\nThird purchase:");
        thirdPurchase();
    }

    private static void firstPurchase() {
        Customer customer = new Customer("crazyCockatoo", "crazy_cockatoo@email.com");
        SalesService salesService = new SalesService(new FakePaymentProvider(), new FakeNotificationService());
        salesService.setCustomer(customer);
        salesService.orderQuantity(5);
        salesService.placeOrder();
    }

    private static void secondPurchase() {
        Customer customer = new Customer("birdieThingie", "birdie_thingie@email.com");
        SalesService salesService = new SalesService(new FakePaymentProvider(), new FakeNotificationService());
        salesService.setCustomer(customer);
        salesService.orderQuantity(1);
        salesService.placeOrder();
    }

    private static void thirdPurchase() {
        Customer customer = new Customer("McParroty", "mc_parroty@email.com");
        SalesService salesService = new SalesService(new FakePaymentProvider(), new FakeNotificationService());
        salesService.setCustomer(customer);
        salesService.orderQuantity(3);
        salesService.placeOrder();
    }
}
