package sdk.jassinaturas.communicators;

import javax.inject.Named;

import sdk.jassinaturas.clients.attributes.Subscription;
import feign.RequestLine;

public interface SubscriptionCommunicator {

    @RequestLine("POST /subscriptions?new_customer=true")
    Subscription createWithCustomer(Subscription subscription);

    @RequestLine("POST /subscriptions?new_customer=false")
    Subscription createWithoutCustomer(Subscription subscription);

    @RequestLine("GET /subscriptions")
    Subscription list();

    @RequestLine("GET /subscriptions/{code}")
    Subscription show(@Named("code") String code);

    @RequestLine("PUT /subscriptions/{code}")
    Subscription update(@Named("code") String code, Subscription customer);

}
