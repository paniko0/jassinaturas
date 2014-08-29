package sdk.jassinaturas.clients.attributes;

public class Duration {
    private String type;
    private int occurrences;

    public String getType() {
        return type;
    }

    public int getOccurrences() {
        return occurrences;
    }

    public Duration withType(String type) {
        this.type = type;
        return this;
    }

    public Duration withOccurrences(int ocurrences) {
        this.occurrences = ocurrences;
        return this;
    }

    @Override
    public String toString() {
        return "Duration{" +
                "type='" + type + '\'' +
                ", occurrences=" + occurrences +
                '}';
    }
}
