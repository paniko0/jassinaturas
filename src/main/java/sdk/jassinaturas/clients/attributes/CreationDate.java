package sdk.jassinaturas.clients.attributes;

public class CreationDate {
    private int day;
    private int hour;
    private int minute;
    private int month;
    private int second;
    private int year;

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public Month getMonth() {
        return Month.getMonth(month);
    }

    public int getSecond() {
        return second;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "CreationDate [day=" + day + ", hour=" + hour + ", minute=" + minute + ", month=" + month + ", second="
                + second + ", year=" + year + "]";
    }

}
