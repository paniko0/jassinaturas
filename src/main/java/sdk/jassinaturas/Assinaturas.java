package sdk.jassinaturas;

import sdk.jassinaturas.clients.*;
import sdk.jassinaturas.clients.attributes.Authentication;
import sdk.jassinaturas.communicators.*;

public class Assinaturas {

    private final Authentication authentication;
    private final Communicator communicator;

    public Assinaturas(final Authentication authentication, final Communicator communicator) {
        this.authentication = authentication;
        this.communicator = communicator;
    }

    public CustomerClient customers() {
        CustomerCommunicator customerCommunicator = communicator.build(CustomerCommunicator.class, authentication);
        return new CustomerClient(customerCommunicator);
    }

    public InvoiceClient invoices() {
        InvoiceCommunicator invoiceCommunicator = communicator.build(InvoiceCommunicator.class, authentication);
        return new InvoiceClient(invoiceCommunicator);
    }

    public PlanClient plans() {
        PlanCommunicator planCommunicator = communicator.build(PlanCommunicator.class, authentication);
        return new PlanClient(planCommunicator);
    }

    public SubscriptionClient subscriptions() {
        SubscriptionCommunicator subscriptionCommunicator = communicator.build(SubscriptionCommunicator.class,
                authentication);
        return new SubscriptionClient(subscriptionCommunicator);
    }

    public CouponClient coupons() {
        CouponCommunicator couponCommunicator = communicator.build(CouponCommunicator.class, authentication);
        return new CouponClient(couponCommunicator);
    }
}
