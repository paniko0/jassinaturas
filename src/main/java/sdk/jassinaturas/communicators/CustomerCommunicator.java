package sdk.jassinaturas.communicators;

import javax.inject.Named;

import sdk.jassinaturas.clients.attributes.BillingInfo;
import sdk.jassinaturas.clients.attributes.Customer;
import feign.RequestLine;

public interface CustomerCommunicator {

    @RequestLine("POST /customers?new_vault=true")
    Customer createWithCreditCard(Customer customer);

    @RequestLine("POST /customers?new_vault=false")
    Customer createWithoutCreditCard(Customer customer);

    @RequestLine("GET /customers")
    Customer list();

    @RequestLine("GET /customers/{code}")
    Customer show(@Named("code") String code);

    @RequestLine("PUT /customers/{code}")
    Customer update(@Named("code") String code, Customer customer);

    @RequestLine("PUT /customers/{code}/billing_infos")
    Customer updateCreditCard(@Named("code") String code, BillingInfo billingInfo);
}
