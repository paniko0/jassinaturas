package sdk.jassinaturas.clients.attributes;

import java.util.List;

public class Subscription {
    private List<Alerts> alerts;
    private int amount;
    private String code;
    private Customer customer;
    private List<Errors> errors;
    private Invoice invoice;
    private List<Invoice> invoices;
    private String message;
    private NextInvoiceDate nextInvoiceDate;
    private Plan plan;
    private SubscriptionStatus status;

    public List<Alerts> getAlerts() {
        return alerts;
    }

    public int getAmount() {
        return amount;
    }

    public String getCode() {
        return code;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Errors> getErrors() {
        return errors;
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

    public NextInvoiceDate getNextInvoiceDate() {
        return nextInvoiceDate;
    }

    public Plan getPlan() {
        return plan;
    }

    public SubscriptionStatus getStatus() {
        return status;
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

    public Subscription withPlan(final Plan plan) {
        this.plan = plan;
        return this;
    }

}
