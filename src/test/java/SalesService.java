public class SalesService {

    private final PaymentsProvider paymentsProvider;
    private final NotificationService notificationService;
    private int numberOfProducts;
    private Customer customer;

    public SalesService(PaymentsProvider paymentsProvider, NotificationService notificationService) {
        this.paymentsProvider = paymentsProvider;
        this.notificationService = notificationService;
    }

    public void orderQuantity(int numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    public void placeOrder() {
        paymentsProvider.pay(numberOfProducts * 5);
        notificationService.sendSuccessfulPurchaseEmail(customer.email, "Thanks for buying!: 1 x The AmazinG parroty food");
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
