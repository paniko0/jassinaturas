package sdk.jassinaturas.communicators;

import javax.inject.Named;

import sdk.jassinaturas.clients.attributes.Subscription;
import feign.Headers;
import feign.RequestLine;

public interface SubscriptionCommunicator {

    @RequestLine("POST /subscriptions?new_customer=true")
    @Headers({ "Content-Type: application/json; charset=utf-8", "Accept: application/json", "Accept-Encoding: utf-8",
            "Accept-Charset: utf-8" })
    Subscription createWithCustomer(Subscription subscription);

    @RequestLine("POST /subscriptions?new_customer=false")
    @Headers({ "Content-Type: application/json; charset=utf-8", "Accept: application/json", "Accept-Encoding: utf-8",
            "Accept-Charset: utf-8" })
    Subscription createWithoutCustomer(Subscription subscription);

    @RequestLine("GET /subscriptions")
    @Headers({ "Content-Type: application/json; charset=utf-8", "Accept: application/json", "Accept-Encoding: utf-8",
            "Accept-Charset: utf-8" })
    Subscription list();

    @RequestLine("GET /subscriptions/{code}")
    Subscription show(@Named("code") String code);

    @RequestLine("PUT /subscriptions/{code}")
    @Headers({ "Content-Type: application/json; charset=utf-8", "Accept: application/json", "Accept-Encoding: utf-8",
            "Accept-Charset: utf-8" })
    Subscription update(@Named("code") String code, Subscription customer);

}
