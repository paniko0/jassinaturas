package sdk.jassinaturas.clients.attributes;

public class Coupon {
    private String code;
    private String name;
    private String description;
    private Discount discount;
    private CouponStatus status;
    private Duration duration;
    private Integer maxRedemptions;
    private ExpirationDate expirationDate;
    private CreationDate creationDate;
    private Boolean inUse;

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

    public CouponStatus getStatus() {
        return status;
    }

    public Coupon withStatus(CouponStatus status) {
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

    public Integer getMaxRedemptions() {
        return maxRedemptions;
    }

    public Coupon withMaxRedemptions(Integer max_redemptions) {
        this.maxRedemptions = max_redemptions;
        return this;
    }

    public ExpirationDate getExpirationDate() {
        return expirationDate;
    }

    public Coupon withExpirationDate(ExpirationDate expiration_date) {
        this.expirationDate = expiration_date;
        return this;
    }

    public CreationDate getCreationDate() {
        return creationDate;
    }

    public Coupon withCreation_date(CreationDate creation_date) {
        this.creationDate = creation_date;
        return this;
    }

    public boolean inUse() {
        if (inUse != null) {
            return inUse;
        }

        return false;
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
                ", maxRedemptions=" + maxRedemptions +
                ", expirationDate=" + expirationDate +
                ", creationDate=" + creationDate +
                '}';
    }
}
