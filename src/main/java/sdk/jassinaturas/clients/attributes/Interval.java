package sdk.jassinaturas.clients.attributes;

public class Interval {
    private Unit unit;
    private int length;

    public Interval withUnit(final Unit unit) {
        this.unit = unit;
        return this;
    }

    public Interval withLength(final int length) {
        this.length = length;
        return this;
    }

    public Unit getUnit() {
        return unit;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Interval [unit=" + unit + ", length=" + length + "]";
    }

}
