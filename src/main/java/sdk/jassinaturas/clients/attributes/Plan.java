package sdk.jassinaturas.clients.attributes;

import java.util.List;

public class Plan {
    private List<Alerts> alerts;
    private int amount;
    private int billingCycles;
    private String code;
    private String description;
    private Interval interval;
    private int maxQty;
    private String message;
    private String name;
    private List<Plan> plans;
    private int setupFee;
    private PlanStatus status;
    private Trial trial;

    public int getAmount() {
        return amount;
    }

    public int getBillingCycles() {
        return billingCycles;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public Interval getInterval() {
        return interval;
    }

    public int getMaxQty() {
        return maxQty;
    }

    public int getMaxQuantity() {
        return maxQty;
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }

    public List<Plan> getPlans() {
        return plans;
    }

    public int getSetupFee() {
        return setupFee;
    }

    public PlanStatus getStatus() {
        return status;
    }

    public Trial getTrial() {
        return trial;
    }

    public boolean hasAlerts() {
        return this.alerts != null && this.alerts.size() > 0;
    }

    public Plan withAmount(final int amount) {
        this.amount = amount;
        return this;
    }

    public Plan withBillingCycles(final int billingCycles) {
        this.billingCycles = billingCycles;
        return this;
    }

    public Plan withCode(final String code) {
        this.code = code;
        return this;
    }

    public Plan withDescription(final String description) {
        this.description = description;
        return this;
    }

    public Plan withInterval(final Interval interval) {
        this.interval = interval;
        return this;
    }

    public Plan withMaxQty(final int maxQty) {
        this.maxQty = maxQty;
        return this;
    }

    public Plan withName(final String name) {
        this.name = name;
        return this;
    }

    public Plan withPlanStatus(final PlanStatus planStatus) {
        this.status = planStatus;
        return this;
    }

    public Plan withSetupFee(final int setupFee) {
        this.setupFee = setupFee;
        return this;
    }

    public Plan withTrial(final Trial trial) {
        this.trial = trial;
        return this;
    }
}
