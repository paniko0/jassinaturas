package sdk.jassinaturas;

import sdk.jassinaturas.clients.Customer;
import sdk.jassinaturas.clients.Plan;
import sdk.jassinaturas.clients.attributes.Authentication;
import sdk.jassinaturas.communicators.Communicator;
import sdk.jassinaturas.communicators.CustomerCommunicator;
import sdk.jassinaturas.communicators.PlanCommunicator;

public class Assinaturas {

    private final Authentication authentication;

    public Assinaturas(final Authentication authentication) {
        this.authentication = authentication;
    }

    public Customer customer() {
        Communicator communicator = new Communicator();
        CustomerCommunicator customerCommunicator = communicator.build(CustomerCommunicator.class, authentication);
        return new Customer(customerCommunicator);
    }

    public Plan plan() {
        Communicator communicator = new Communicator();
        PlanCommunicator planCommunicator = communicator.build(PlanCommunicator.class, authentication);
        return new Plan(planCommunicator);
    }
}
