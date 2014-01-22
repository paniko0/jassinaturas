package sdk.jassinaturas.clients;

import sdk.jassinaturas.clients.attributes.Subscription;
import sdk.jassinaturas.communicators.SubscriptionCommunicator;
import sdk.jassinaturas.exceptions.ApiResponseErrorException;
import sdk.jassinaturas.serializers.GsonDeserializer;

public class SubscriptionClient {

    private final SubscriptionCommunicator subscriptionCommunicator;

    public SubscriptionClient(final SubscriptionCommunicator subscriptionCommunicator) {
        this.subscriptionCommunicator = subscriptionCommunicator;
    }

    public Subscription create(final Subscription toBeCreated) {
        try {
            Subscription subscription = null;
            if (shouldCreateCustomer(toBeCreated)) {
                subscription = subscriptionCommunicator.createWithCustomer(toBeCreated);
                return subscription;
            } else {
                subscription = subscriptionCommunicator.createWithoutCustomer(toBeCreated);
                return subscription;
            }
        } catch (ApiResponseErrorException e) {
            GsonDeserializer gson = new GsonDeserializer();
            return gson.deserialize(e.getMessage(), Subscription.class);
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
