package sdk.jassinaturas.clients.attributes;

import java.util.GregorianCalendar;

public class Payment {
    private CreationDate creationDate;
    private int id;
    private int moipId;
    private PaymentMethod paymentMethod;
    private PaymentStatus status;

    public GregorianCalendar getCreationDate() {
        return new GregorianCalendar(this.creationDate.getYear(), creationDate.getMonth() - 1, creationDate.getDay(),
                creationDate.getHour(), creationDate.getMinute(), creationDate.getSecond());
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
