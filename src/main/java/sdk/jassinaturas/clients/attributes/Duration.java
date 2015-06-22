package sdk.jassinaturas.clients.attributes;

public class Duration {
    private DurationType type;
    private int occurrences;

    public DurationType getType() {
        return type;
    }

    public int getOccurrences() {
        return occurrences;
    }

    public Duration withType(DurationType type) {
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
