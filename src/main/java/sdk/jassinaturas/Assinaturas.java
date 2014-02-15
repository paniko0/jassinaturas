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

    public Assinaturas(final Authentication authentication) {
        this.authentication = authentication;
    }

    public CustomerClient customer() {
        Communicator communicator = new Communicator();
        CustomerCommunicator customerCommunicator = communicator.build(CustomerCommunicator.class, authentication);
        return new CustomerClient(customerCommunicator);
    }

    public InvoiceClient invoice() {
        Communicator communicator = new Communicator();
        InvoiceCommunicator invoiceCommunicator = communicator.build(InvoiceCommunicator.class, authentication);
        return new InvoiceClient(invoiceCommunicator);
    }

    public PlanClient plan() {
        Communicator communicator = new Communicator();
        PlanCommunicator planCommunicator = communicator.build(PlanCommunicator.class, authentication);
        return new PlanClient(planCommunicator);
    }

    public SubscriptionClient subscription() {
        Communicator communicator = new Communicator();
        SubscriptionCommunicator subscriptionCommunicator = communicator.build(SubscriptionCommunicator.class,
                authentication);
        return new SubscriptionClient(subscriptionCommunicator);
    }
}
