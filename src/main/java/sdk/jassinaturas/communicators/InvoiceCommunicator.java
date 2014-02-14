package sdk.jassinaturas.communicators;

import javax.inject.Named;

import sdk.jassinaturas.clients.attributes.Invoice;
import feign.RequestLine;

public interface InvoiceCommunicator {

    @RequestLine("GET /invoices/{code}")
    Invoice show(@Named("code") String code);
}
