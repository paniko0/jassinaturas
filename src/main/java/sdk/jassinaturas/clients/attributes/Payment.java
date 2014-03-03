package sdk.jassinaturas.clients.attributes;


public class Payment {
    private CreationDate creationDate;
    private int id;
    private int moipId;
    private PaymentMethod paymentMethod;
    private PaymentStatus status;

    public CreationDate getCreationDate() {
        return creationDate;
    }

    public int getId() {
        return id;
    }

    public int getMoipId() {
        return moipId;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public PaymentStatus getStatus() {
        return status;
    }

}
