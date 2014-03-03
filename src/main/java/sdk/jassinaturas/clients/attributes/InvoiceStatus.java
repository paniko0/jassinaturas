package sdk.jassinaturas.clients.attributes;

public class InvoiceStatus {
    private int code;
    private String description;

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "InvoiceStatus [code=" + code + ", description=" + description + "]";
    }

}
