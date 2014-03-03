package sdk.jassinaturas;

import sdk.jassinaturas.clients.CustomerClient;
import sdk.jassinaturas.clients.InvoiceClient;
import sdk.jassinaturas.clients.PlanClient;
import sdk.jassinaturas.clients.SubscriptionClient;
import sdk.jassinaturas.clients.attributes.Authentication;
import sdk.jassinaturas.communicators.Communicator;
import sdk.jassinaturas.communicators.CustomerCommunicator;
import sdk.jassinaturas.communicators.InvoiceCommunicator;
import sdk.jassinaturas.communicators.PlanCommunicator;
import sdk.jassinaturas.communicators.SubscriptionCommunicator;

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
}
