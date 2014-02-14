package sdk.jassinaturas.communicators;

import javax.inject.Named;

import sdk.jassinaturas.clients.attributes.Subscription;
import feign.RequestLine;

public interface SubscriptionCommunicator {

    @RequestLine("PUT /subscriptions/{code}/activate")
    Subscription activate(@Named("code") String code);

    @RequestLine("PUT /subscriptions/{code}/cancel")
    Subscription cancel(@Named("code") String code);

    @RequestLine("POST /subscriptions?new_customer=true")
    Subscription createWithCustomer(Subscription subscription);

    @RequestLine("POST /subscriptions?new_customer=false")
    Subscription createWithoutCustomer(Subscription subscription);

    @RequestLine("GET /subscriptions/{code}/invoices")
    Subscription invoices(@Named("code") String subscriptionCode);

    @RequestLine("GET /subscriptions")
    Subscription list();

    @RequestLine("GET /subscriptions/{code}")
    Subscription show(@Named("code") String code);

    @RequestLine("PUT /subscriptions/{code}/suspend")
    Subscription suspend(@Named("code") String code);

    @RequestLine("PUT /subscriptions/{code}")
    Subscription update(@Named("code") String code, Subscription subscription);

}
