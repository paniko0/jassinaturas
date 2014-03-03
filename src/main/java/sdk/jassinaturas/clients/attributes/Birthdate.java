package sdk.jassinaturas.clients.attributes;

public class Birthdate {
    private int birthdateDay;
    private int birthdateMonth;
    private int birthdateYear;

    public int getBirthdateDay() {
        return birthdateDay;
    }

    public int getBirthdateMonth() {
        return birthdateMonth;
    }

    public int getBirthdateYear() {
        return birthdateYear;
    }

    public Birthdate withDay(final int day) {
        this.birthdateDay = day;
        return this;
    }

    public Birthdate withMonth(final Month month) {
        this.birthdateMonth = month.getNumeric();
        return this;
    }

    public Birthdate withYear(final int year) {
        this.birthdateYear = year;
        return this;
    }

    @Override
    public String toString() {
        return "Birthdate [birthdateDay=" + birthdateDay + ", birthdateMonth=" + birthdateMonth + ", birthdateYear="
                + birthdateYear + "]";
    }

}
