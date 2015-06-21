package sdk.jassinaturas.clients.attributes;

public class Discount {
    private String type;
    private int value;

    public String getType() {
        return type;
    }

    public Discount withType(String type) {
        this.type = type;
        return this;
    }

    public int getValue() {
        return value;
    }

    public Discount withValue(int value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}
