package sdk.jassinaturas.clients.attributes;

public class CreditCard {
    private String brand;
    private String expirationMonth;
    private String expirationYear;
    private String firstSixDigits;
    private String holderName;
    private String lastFourDigits;
    private String number;
    private String vault;

    public String getBrand() {
        return brand;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    public String getFirstSixDigits() {
        return firstSixDigits;
    }

    public String getHolderName() {
        return holderName;
    }

    public String getLastFourDigits() {
        return lastFourDigits;
    }

    public String getNumber() {
        return number;
    }

    public String getVault() {
        return vault;
    }

    public CreditCard withExpirationMonth(final String expirationMonth) {
        this.expirationMonth = expirationMonth;
        return this;
    }

    public CreditCard withExpirationYear(final String expirationYear) {
        this.expirationYear = expirationYear;
        return this;
    }

    public CreditCard withHolderName(final String holderName) {
        this.holderName = holderName;
        return this;
    }

    public CreditCard withNumber(final String number) {
        this.number = number;
        return this;
    }

    @Override
    public String toString() {
        return "CreditCard [brand=" + brand + ", expirationMonth=" + expirationMonth + ", expirationYear="
                + expirationYear + ", firstSixDigits=" + firstSixDigits + ", holderName=" + holderName
                + ", lastFourDigits=" + lastFourDigits + ", number=" + number + ", vault=" + vault + "]";
    }

}
