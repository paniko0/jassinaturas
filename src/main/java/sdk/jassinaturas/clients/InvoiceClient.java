package sdk.jassinaturas.clients;

import sdk.jassinaturas.clients.attributes.Invoice;
import sdk.jassinaturas.communicators.InvoiceCommunicator;

public class InvoiceClient {

    private final InvoiceCommunicator invoiceCommunicator;

    public InvoiceClient(final InvoiceCommunicator invoiceCommunicator) {
        this.invoiceCommunicator = invoiceCommunicator;
    }

    public Invoice show(final int id) {
        Invoice invoice = invoiceCommunicator.show(id);
        return invoice;
    }

}
