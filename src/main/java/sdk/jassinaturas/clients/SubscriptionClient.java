package sdk.jassinaturas.clients;

import sdk.jassinaturas.clients.attributes.Subscription;
import sdk.jassinaturas.communicators.SubscriptionCommunicator;

public class SubscriptionClient {

    private final SubscriptionCommunicator subscriptionCommunicator;

    public SubscriptionClient(final SubscriptionCommunicator subscriptionCommunicator) {
        this.subscriptionCommunicator = subscriptionCommunicator;
    }

    public Subscription create(final Subscription toBeCreated) {

        Subscription subscription = null;
        if (shouldCreateCustomer(toBeCreated)) {
            subscription = subscriptionCommunicator.createWithCustomer(toBeCreated);
            return subscription;
        } else {
            subscription = subscriptionCommunicator.createWithoutCustomer(toBeCreated);
            return subscription;
        }

    }

    private boolean shouldCreateCustomer(final Subscription toBeCreated) {
        if (toBeCreated.getCustomer().getAddress() == null && toBeCreated.getCustomer().getBillingInfo() == null) {
            return false;
        }

        if (toBeCreated.getCustomer().getAddress() == null && toBeCreated.getCustomer().getBillingInfo() != null) {
            return false;
        }

        return true;
    }

}
