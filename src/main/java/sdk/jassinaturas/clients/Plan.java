package sdk.jassinaturas.clients;

import sdk.jassinaturas.clients.attributes.Authentication;
import sdk.jassinaturas.clients.attributes.Interval;
import sdk.jassinaturas.clients.attributes.PlanStatus;
import sdk.jassinaturas.clients.attributes.Trial;
import sdk.jassinaturas.communicators.PlanCommunicator;

public class Plan {

	private String code;
	private String name;
	private String description;
	private int amount;
	private int setupFee;
	private int maxQuantity;
	private PlanStatus planStatus;
	private Interval interval;
	private int billingCycles;
	private Trial trial;
	
	private PlanCommunicator planCommunicator;
	private Authentication authentication;

	public Plan(PlanCommunicator planCommunicator, Authentication authentication) {
		this.planCommunicator = planCommunicator;
		this.authentication = authentication;
	}

	public Plan show(final String code) {
		Plan plan = planCommunicator.show(code);
		return plan;
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
		return maxQuantity;
	}

	public PlanStatus getPlanStatus() {
		return planStatus;
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

	@Override
	public String toString() {
		return "Plan [code=" + code + ", name=" + name + ", description="
				+ description + ", amount=" + amount + ", setupFee=" + setupFee
				+ ", maxQuantity=" + maxQuantity + ", planStatus=" + planStatus
				+ ", interval=" + interval + ", billingCycles=" + billingCycles
				+ ", trial=" + trial + "]";
	}

}
