package sdk.jassinaturas.clients.attributes;

import java.util.GregorianCalendar;
import java.util.List;

public class Subscription {
    private List<Alerts> alerts;
    private int amount;
    private String code;
    private CreationDate creationDate;
    private Customer customer;
    private List<Errors> errors;
    private ExpirationDate expirationDate;
    private Invoice invoice;
    private List<Invoice> invoices;
    private String message;
    private NextInvoiceDate nextInvoiceDate;
    private Plan plan;
    private SubscriptionStatus status;
    private List<Subscription> subscriptions;

    public List<Alerts> getAlerts() {
        return alerts;
    }

    public int getAmount() {
        return amount;
    }

    public String getCode() {
        return code;
    }

    public GregorianCalendar getCreationDate() {
        return new GregorianCalendar(creationDate.getYear(), creationDate.getMonth() - 1, creationDate.getDay(),
                creationDate.getHour(), creationDate.getMinute(), creationDate.getSecond());
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Errors> getErrors() {
        return errors;
    }

    public GregorianCalendar getExpirationDate() {
        return new GregorianCalendar(expirationDate.getYear(), expirationDate.getMonth() - 1, expirationDate.getDay());
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public String getMessage() {
        return message;
    }

    public GregorianCalendar getNextInvoiceDate() {
        return new GregorianCalendar(nextInvoiceDate.getYear(), nextInvoiceDate.getMonth() - 1,
                nextInvoiceDate.getDay());
    }

    public Plan getPlan() {
        return plan;
    }

    public SubscriptionStatus getStatus() {
        return status;
    }

    public List<Subscription> getSubscriptions() {

        return this.subscriptions;
    }

    public boolean hasAlerts() {
        return this.alerts != null && this.alerts.size() > 0;
    }

    public boolean hasErrors() {
        return errors != null && errors.size() > 0;
    }

    public Subscription withAmount(final int amount) {
        this.amount = amount;
        return this;
    }

    public Subscription withCode(final String code) {
        this.code = code;
        return this;
    }

    public Subscription withCustomer(final Customer customer) {
        this.customer = customer;
        return this;
    }

    public Subscription withNextInvoiceDate(final NextInvoiceDate nextInvoiceDate) {
        this.nextInvoiceDate = nextInvoiceDate;
        return this;
    }

    public Subscription withPlan(final Plan plan) {
        this.plan = plan;
        return this;
    }

}
