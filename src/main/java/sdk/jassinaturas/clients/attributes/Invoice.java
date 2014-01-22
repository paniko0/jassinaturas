package sdk.jassinaturas.clients.attributes;

public class Invoice {

    public int amount;
    public int id;
    public InvoiceStatus status;

    public int getAmount() {
        return amount;
    }

    public int getId() {
        return id;
    }

    public InvoiceStatus getStatus() {
        return status;
    }

}
