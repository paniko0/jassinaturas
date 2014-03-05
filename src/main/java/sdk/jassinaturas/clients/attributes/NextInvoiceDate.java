package sdk.jassinaturas.clients.attributes;

public class NextInvoiceDate {
    private int day;
    private int month;
    private int year;

    public int getDay() {
        return day;
    }

    public Month getMonth() {
        return Month.getMonth(month);
    }

    public int getYear() {
        return year;
    }

    public NextInvoiceDate withDay(final int day) {
        this.day = day;
        return this;
    }

    public NextInvoiceDate withMonth(final Month month) {
        this.month = month.getNumeric();
        return this;
    }

    public NextInvoiceDate withYear(final int year) {
        this.year = year;
        return this;
    }

    @Override
    public String toString() {
        return "NextInvoiceDate [day=" + day + ", month=" + month + ", year=" + year + "]";
    }

}
