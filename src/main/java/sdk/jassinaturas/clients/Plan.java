package sdk.jassinaturas.clients;

import java.util.List;

import sdk.jassinaturas.clients.attributes.Alerts;
import sdk.jassinaturas.clients.attributes.Errors;
import sdk.jassinaturas.clients.attributes.Interval;
import sdk.jassinaturas.clients.attributes.PlanStatus;
import sdk.jassinaturas.clients.attributes.Trial;
import sdk.jassinaturas.communicators.PlanCommunicator;
import sdk.jassinaturas.exceptions.ApiResponseErrorException;
import sdk.jassinaturas.serializers.GsonDeserializer;

public class Plan {

    private List<Alerts> alerts;

    private int amount;
    private int billingCycles;
    private String code;
    private String description;
    private List<Errors> errors;
    private Interval interval;
    private int maxQty;
    private String message;
    private String name;
    private PlanCommunicator planCommunicator;

    private List<Plan> plans;
    private int setupFee;
    private PlanStatus status;

    private Trial trial;

    public Plan() {
    }

    public Plan(final PlanCommunicator planCommunicator) {
        this.planCommunicator = planCommunicator;
    }

    public Plan active(final Plan toActivate) {
        Plan plan = planCommunicator.activate(toActivate.getCode());
        return plan;
    }

    public Plan create(final Plan toBeCreated) {
        try {
            Plan plan = planCommunicator.create(toBeCreated);
            return plan;
        } catch (ApiResponseErrorException e) {
            GsonDeserializer gson = new GsonDeserializer();
            return gson.deserialize(e.getMessage(), Plan.class);
        }

    }

    public List<Alerts> getAlerts() {
        return alerts;
    }

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

    public List<Errors> getErrors() {
        return errors;
    }

    public Interval getInterval() {
        return interval;
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
        return alerts != null && alerts.size() > 0;
    }

    public boolean hasErrors() {
        return errors != null && errors.size() > 0;
    }

    public Plan inactive(final Plan toInactivate) {
        Plan plan = planCommunicator.inactivate(toInactivate.getCode());
        return plan;
    }

    public List<Plan> list() {
        Plan plans = planCommunicator.list();
        return plans.getPlans();
    }

    public Plan show(final String code) {
        Plan plan = planCommunicator.show(code);
        return plan;
    }

    @Override
    public String toString() {
        return "Plan [code=" + code + ", name=" + name + ", description=" + description + ", amount=" + amount
                + ", setupFee=" + setupFee + ", maxQuantity=" + maxQty + ", planStatus=" + status + ", interval="
                + interval + ", billingCycles=" + billingCycles + ", trial=" + trial + "]";
    }

    public Plan update(final Plan toBeUpdated) {
        Plan plan = planCommunicator.update(toBeUpdated.getCode(), toBeUpdated);
        return plan;
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
