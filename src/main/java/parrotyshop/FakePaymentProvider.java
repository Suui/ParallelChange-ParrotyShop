package parrotyshop;

import parrotyshop.interfaces.PaymentsProvider;

public class FakePaymentProvider implements PaymentsProvider {

    @Override
    public void pay(int coins) {
        System.out.println("Received a payment of " + coins + " coins");
    }
}
