package sdk.jassinaturas.clients;

import java.util.List;

import sdk.jassinaturas.clients.attributes.Invoice;
import sdk.jassinaturas.clients.attributes.Subscription;
import sdk.jassinaturas.communicators.SubscriptionCommunicator;

public class SubscriptionClient {

    private final SubscriptionCommunicator subscriptionCommunicator;

    public SubscriptionClient(final SubscriptionCommunicator subscriptionCommunicator) {
        this.subscriptionCommunicator = subscriptionCommunicator;
    }

    public Subscription activate(final String code) {
        Subscription subscription = subscriptionCommunicator.activate(code);
        return subscription;
    }

    public Subscription cancel(final String code) {
        Subscription subscription = subscriptionCommunicator.cancel(code);
        return subscription;
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

    public List<Invoice> invoices(final String subscriptionCode) {
        Subscription subscription = subscriptionCommunicator.invoices(subscriptionCode);
        return subscription.getInvoices();
    }

    public List<Subscription> list() {
        Subscription subscriptions = subscriptionCommunicator.list();
        return subscriptions.getSubscriptions();
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

    public Subscription show(final String code) {
        Subscription subscription = subscriptionCommunicator.show(code);
        return subscription;
    }

    public Subscription suspend(final String code) {
        Subscription subscription = subscriptionCommunicator.suspend(code);
        return subscription;
    }

    public Subscription update(final Subscription toUpdate) {
        Subscription subscription = subscriptionCommunicator.update(toUpdate.getCode(), toUpdate);
        return subscription;
    }

}
