package sdk.jassinaturas.clients;

import java.util.List;

import sdk.jassinaturas.clients.attributes.Alerts;
import sdk.jassinaturas.clients.attributes.Errors;
import sdk.jassinaturas.clients.attributes.Interval;
import sdk.jassinaturas.clients.attributes.PlanStatus;
import sdk.jassinaturas.clients.attributes.Trial;
import sdk.jassinaturas.communicators.PlanCommunicator;

public class Plan {
	
	private List<Plan> plans;

	private String code;
	private String name;
	private String description;
	private int amount;
	private int setupFee;
	private int maxQty;
	private PlanStatus status;
	private Interval interval;
	private int billingCycles;
	private Trial trial;
	
	private String message;
	private List<Alerts> alerts;
	private List<Errors> errors;
	
	private PlanCommunicator planCommunicator;
	
	public Plan() {}

	public Plan(PlanCommunicator planCommunicator) {
		this.planCommunicator = planCommunicator;
	}

	public Plan show(final String code) {
		Plan plan = planCommunicator.show(code);
		return plan;
	}
	
	public Plan create(final Plan toBeCreated) {
		Plan plan = planCommunicator.create(toBeCreated);
		return plan;
	}
	
	public List<Plan> list() {
		Plan plans = planCommunicator.list();
		return plans.getPlans();
	}
	
	public Plan update(Plan toBeUpdated) {
		Plan plan = planCommunicator.update(toBeUpdated.getCode(), toBeUpdated);
		return plan;
	}
	
	public Plan withCode(String code) {
		this.code = code;
		return this;
	}
	
	public Plan withName(String name) {
		this.name = name;
		return this;
	}
	
	public Plan withDescription(String description) {
		this.description = description;
		return this;
	}
	
	public Plan withAmount(int amount) {
		this.amount = amount;
		return this;
	}
	
	public Plan withSetupFee(int setupFee) {
		this.setupFee = setupFee;
		return this;
	}
	
	public Plan withMaxQty(int maxQty) {
		this.maxQty = maxQty;
		return this;
	}
	
	public Plan withPlanStatus(PlanStatus planStatus) {
		this.status = planStatus;
		return this;
	}
	
	public Plan withInterval(Interval interval) {
		this.interval = interval;
		return this;
	}
	
	public Plan withBillingCycles(int billingCycles) {
		this.billingCycles = billingCycles;
		return this;
	}
	
	public Plan withTrial(Trial trial) {
		this.trial = trial;
		return this;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getAmount() {
		return amount;
	}

	public int getSetupFee() {
		return setupFee;
	}

	public int getMaxQuantity() {
		return maxQty;
	}

	public PlanStatus getStatus() {
		return status;
	}

	public Interval getInterval() {
		return interval;
	}

	public int getBillingCycles() {
		return billingCycles;
	}

	public Trial getTrial() {
		return trial;
	}
	
	public List<Alerts> getAlerts() {
		return alerts;
	}
	
	public String getMessage() {
		return message;
	}
	
	public List<Errors> getErrors() {
		return errors;
	}
	
	public boolean hasErrors() {
		return errors != null && errors.size() > 0;
	}
	
	public boolean hasAlerts() {
		return alerts != null && alerts.size() > 0;
	}
	
	public List<Plan> getPlans() {
		return plans;
	}

	@Override
	public String toString() {
		return "Plan [code=" + code + ", name=" + name + ", description="
				+ description + ", amount=" + amount + ", setupFee=" + setupFee
				+ ", maxQuantity=" + maxQty + ", planStatus=" + status
				+ ", interval=" + interval + ", billingCycles=" + billingCycles
				+ ", trial=" + trial + "]";
	}
}
