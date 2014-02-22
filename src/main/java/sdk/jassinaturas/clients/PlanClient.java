package sdk.jassinaturas.clients;

import java.util.List;

import sdk.jassinaturas.clients.attributes.Plan;
import sdk.jassinaturas.communicators.PlanCommunicator;

public class PlanClient {

    private PlanCommunicator planCommunicator;

    public PlanClient() {
    }

    public PlanClient(final PlanCommunicator planCommunicator) {
        this.planCommunicator = planCommunicator;
    }

    public Plan active(final String code) {
        Plan plan = planCommunicator.activate(code);
        return plan;
    }

    public Plan create(final Plan toBeCreated) {
        Plan plan = planCommunicator.create(toBeCreated);
        return plan;

    }

    public Plan inactive(final String code) {
        Plan plan = planCommunicator.inactivate(code);
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

    public Plan update(final Plan toBeUpdated) {
        Plan plan = planCommunicator.update(toBeUpdated.getCode(), toBeUpdated);
        return plan;
    }

}
