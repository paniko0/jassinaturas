package sdk.jassinaturas.clients.attributes;

public class Item {
    private int amount;
    private String type;

    public int getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Item [amount=" + amount + ", type=" + type + "]";
    }

}
