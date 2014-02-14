package sdk.jassinaturas.clients.attributes;

import java.util.GregorianCalendar;

public class Invoice {

    public int amount;
    private CreationDate creationDate;
    public int id;
    public int occurrence;
    public InvoiceStatus status;
    private String subscriptionCode;

    public int getAmount() {
        return amount;
    }

    public GregorianCalendar getCreationDate() {
        return new GregorianCalendar(creationDate.getYear(), creationDate.getMonth() - 1, creationDate.getDay(),
                creationDate.getHour(), creationDate.getMinute(), creationDate.getSecond());
    }

    public int getId() {
        return id;
    }

    public int getOccurrence() {
        return occurrence;
    }

    public InvoiceStatus getStatus() {
        return status;
    }

    public String getSubscriptionCode() {
        return subscriptionCode;
    }

}
