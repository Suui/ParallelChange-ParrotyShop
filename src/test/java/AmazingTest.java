import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class AmazingTest {

    private PaymentsProvider paymentsProvider;
    private NotificationService notificationService;
    private SalesService salesService;

    @BeforeEach
    public void setup() {
        paymentsProvider = mock(PaymentsProvider.class);
        notificationService = mock(NotificationService.class);
        salesService = new SalesService(paymentsProvider, notificationService);
    }

    @Test
    public void gets_the_products() {
        String product = new ProductsService().getProduct();

        assertThat(product).isEqualTo("The AmazinG parroty food");
    }

    @Test
    public void charges_the_price_in_coins() {
        int productPrice = 5;
        int numberOfProducts = 3;

        salesService.orderQuantity(numberOfProducts);
        salesService.placeOrder();

        verify(paymentsProvider, times(1)).pay(numberOfProducts * productPrice);
    }

    @Test
    public void notify_the_user_upon_successful_purchase() {
        Customer customer = new Customer("parrotyFan", "parroty_fan@gmail.com");

        salesService.setCustomer(customer);
        salesService.orderQuantity(1);
        salesService.placeOrder();

        verify(notificationService, times(1))
                .sendSuccessfulPurchaseEmail(customer.email, "Thanks for buying!: 1 x The AmazinG parroty food");
    }

    public static void main(String[] args) {
        Customer customer = new Customer("parroty_fan", "parroty_fan@gmail.com");
        String productName = new ProductsService().getProduct();
        SalesService salesService = new SalesService(new FakePaymentProvider(), new FakeNotificationService());
        salesService.setCustomer(customer);
        salesService.orderQuantity(3);
        salesService.placeOrder();
    }
}
