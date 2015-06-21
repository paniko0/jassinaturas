package sdk.jassinaturas.clients.attributes;

public class Coupon {
    private String code;
    private String name;
    private String description;
    private Discount discount;
    private String status;
    private Duration duration;
    private int max_redemptions;
    private ExpirationDate expiration_date;
    private CreationDate creation_date;

    public String getCode() {
        return code;
    }

    public Coupon withCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public Coupon withName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Coupon withDescription(String description) {
        this.description = description;
        return this;
    }

    public Discount getDiscount() {
        return discount;
    }

    public Coupon withDiscount(Discount discount) {
        this.discount = discount;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Coupon withStatus(String status) {
        this.status = status;
        return this;
    }

    public Duration getDuration() {
        return duration;
    }

    public Coupon withDuration(Duration duration) {
        this.duration = duration;
        return this;
    }

    public int getMax_redemptions() {
        return max_redemptions;
    }

    public Coupon withMax_redemptions(int max_redemptions) {
        this.max_redemptions = max_redemptions;
        return this;
    }

    public ExpirationDate getExpiration_date() {
        return expiration_date;
    }

    public Coupon withExpiration_date(ExpirationDate expiration_date) {
        this.expiration_date = expiration_date;
        return this;
    }

    public CreationDate getCreation_date() {
        return creation_date;
    }

    public Coupon withCreation_date(CreationDate creation_date) {
        this.creation_date = creation_date;
        return this;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", discount=" + discount +
                ", status='" + status + '\'' +
                ", duration=" + duration +
                ", max_redemptions=" + max_redemptions +
                ", expiration_date=" + expiration_date +
                ", creation_date=" + creation_date +
                '}';
    }
}
