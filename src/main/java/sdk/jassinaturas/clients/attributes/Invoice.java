package sdk.jassinaturas.clients.attributes;

import java.util.List;

public class Invoice {

    public int amount;
    private CreationDate creationDate;
    private Customer customer;
    public int id;
    private List<Item> items;
    public int occurrence;
    private List<Payment> payments;
    private Plan plan;
    public InvoiceStatus status;
    private String subscriptionCode;

    public int getAmount() {
        return amount;
    }

    public CreationDate getCreationDate() {
        return creationDate;
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

    public List<Payment> getPayments() {
        return payments;
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

    @Override
    public String toString() {
        return "Invoice [amount=" + amount + ", creationDate=" + creationDate + ", customer=" + customer + ", id=" + id
                + ", items=" + items + ", occurrence=" + occurrence + ", payments=" + payments + ", plan=" + plan
                + ", status=" + status + ", subscriptionCode=" + subscriptionCode + "]";
    }

}
