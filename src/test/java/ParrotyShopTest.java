import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parrotyshop.Customer;
import parrotyshop.SalesService;
import parrotyshop.interfaces.NotificationService;
import parrotyshop.interfaces.PaymentsProvider;

import static org.mockito.Mockito.*;

public class ParrotyShopTest {

    private PaymentsProvider paymentsProvider;
    private NotificationService notificationService;
    private SalesService salesService;
    private Customer customer;

    @BeforeEach
    public void setup() {
        paymentsProvider = mock(PaymentsProvider.class);
        notificationService = mock(NotificationService.class);
        salesService = new SalesService(paymentsProvider, notificationService);
        customer = new Customer("parrotyFan", "parroty_fan@email.com");
    }

    @Test
    public void charges_the_price_in_coins() {
        int productPrice = 5;
        int numberOfProducts = 3;

        salesService.setCustomer(customer);
        salesService.orderQuantity(numberOfProducts);
        salesService.placeOrder();

        verify(paymentsProvider, times(1)).pay(numberOfProducts * productPrice);
    }

    @Test
    public void notify_the_business_upon_successful_purchase() {
        salesService.setCustomer(customer);
        salesService.orderQuantity(2);
        salesService.placeOrder();

        verify(notificationService, times(1))
                .notifySale("Customer with email: " + customer.email + ", bought: 2 x The AmazinG parroty food");
    }

    @Test
    public void notify_the_user_upon_successful_purchase() {
        salesService.setCustomer(customer);
        salesService.orderQuantity(1);
        salesService.placeOrder();

        verify(notificationService, times(1))
                .sendSuccessfulPurchaseEmail(customer.email, "Thanks for buying!: 1 x The AmazinG parroty food");
    }
}
