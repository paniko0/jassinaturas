package sdk.jassinaturas.clients.attributes;

public class ExpirationDate {
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

    public ExpirationDate withDay(final int day) {
        this.day = day;
        return this;
    }

    public ExpirationDate withMonth(final Month month) {
        this.month = month.getNumeric();
        return this;
    }

    public ExpirationDate withYear(final int year) {
        this.year = year;
        return this;
    }

    @Override
    public String toString() {
        return "ExpirationDate [day=" + day + ", month=" + Month.getMonth(month) + ", year=" + year + "]";
    }

}
