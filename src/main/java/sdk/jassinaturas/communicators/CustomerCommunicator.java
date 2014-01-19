package sdk.jassinaturas.communicators;

import javax.inject.Named;

import sdk.jassinaturas.clients.Customer;
import sdk.jassinaturas.clients.attributes.BillingInfo;
import feign.Headers;
import feign.RequestLine;

public interface CustomerCommunicator {

    @RequestLine("POST /customers?new_vault=true")
    @Headers({ "Content-Type: application/json; charset=utf-8", "Accept: application/json", "Accept-Encoding: utf-8",
            "Accept-Charset: utf-8" })
    Customer createWithCreditCard(Customer customer);

    @RequestLine("POST /customers?new_vault=false")
    @Headers({ "Content-Type: application/json; charset=utf-8", "Accept: application/json", "Accept-Encoding: utf-8",
            "Accept-Charset: utf-8" })
    Customer createWithoutCreditCard(Customer customer);

    @RequestLine("GET /customers")
    @Headers({ "Content-Type: application/json; charset=utf-8", "Accept: application/json", "Accept-Encoding: utf-8",
            "Accept-Charset: utf-8" })
    Customer list();

    @RequestLine("GET /customers/{code}")
    Customer show(@Named("code") String code);

    @RequestLine("PUT /customers/{code}")
    @Headers({ "Content-Type: application/json; charset=utf-8", "Accept: application/json", "Accept-Encoding: utf-8",
            "Accept-Charset: utf-8" })
    Customer update(@Named("code") String code, Customer customer);

    @RequestLine("PUT /customers/{code}/billing_infos")
    @Headers({ "Content-Type: application/json; charset=utf-8", "Accept: application/json", "Accept-Encoding: utf-8",
            "Accept-Charset: utf-8" })
    Customer updateCreditCard(@Named("code") String code, BillingInfo billingInfo);
}
