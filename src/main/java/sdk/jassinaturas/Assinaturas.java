package sdk.jassinaturas;

import sdk.jassinaturas.clients.Plan;
import sdk.jassinaturas.clients.attributes.Authentication;
import sdk.jassinaturas.communicators.Communicator;
import sdk.jassinaturas.communicators.PlanCommunicator;

public class Assinaturas {
	
	private Authentication authentication;
	
	
	public Assinaturas(Authentication authentication) {
		this.authentication = authentication;
	}

	public Plan plan(){
		Communicator communicator = new Communicator();
		PlanCommunicator planCommunicator = communicator.build(PlanCommunicator.class);
		return new Plan(planCommunicator, authentication);
	}
}
