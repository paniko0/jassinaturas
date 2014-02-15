package sdk.jassinaturas.clients.attributes;

import java.util.GregorianCalendar;
import java.util.List;

public class Invoice {

    public int amount;
    private CreationDate creationDate;
    private Customer customer;
    public int id;
    private List<Item> items;
    public int occurrence;
    private Plan plan;
    public InvoiceStatus status;
    private String subscriptionCode;

    public int getAmount() {
        return amount;
    }

    public GregorianCalendar getCreationDate() {
        return new GregorianCalendar(creationDate.getYear(), creationDate.getMonth() - 1, creationDate.getDay(),
                creationDate.getHour(), creationDate.getMinute(), creationDate.getSecond());
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getId() {
        return id;
    }

    public List<Item> getItems() {
        return items;
    }

    public int getOccurrence() {
        return occurrence;
    }

    public Plan getPlan() {
        return plan;
    }

    public InvoiceStatus getStatus() {
        return status;
    }

    public String getSubscriptionCode() {
        return subscriptionCode;
    }

}
