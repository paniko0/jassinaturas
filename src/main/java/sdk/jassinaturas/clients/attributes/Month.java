package sdk.jassinaturas.clients.attributes;

public enum Month {
    UNKNOWN(0), JANUARY(1), FEBRUARY(2), MARCH(3), APRIL(4), MAY(5), JUNE(6), JULY(7), AUGUST(8), SEPTEMBER(9), OCTOBER(
            10), NOVEMBER(11), DECEMBER(12);

    private int numeric;

    private Month(final int numeric) {
        this.numeric = numeric;
    }

    public int getNumeric() {
        return numeric;
    }

    public static Month getMonth(final int numeric) {
        for (Month month : values()) {
            if (month.getNumeric() == numeric) {
                return month;
            }
        }

        return Month.UNKNOWN;
    }
}
