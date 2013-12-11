package sdk.jassinaturas.clients;

import org.junit.Rule;
import org.junit.Test;

import sdk.jassinaturas.Assinaturas;
import sdk.jassinaturas.clients.attributes.Authentication;
import co.freeside.betamax.Betamax;
import co.freeside.betamax.Recorder;

public class PlanTest {
	
	private Assinaturas assinaturas = new Assinaturas(new Authentication("123", "abc"));

	@Rule
	public Recorder recorder = new Recorder();

	@Test
	public void shouldCreateANewPlan() {

	}

	@Test
	public void shouldUpdateAPlan() {

	}

	@Test
	public void shouldListAllPlans() {
		
	}

	@Betamax(tape = "GET_SINGLE_PLAN")
	@Test
	public void shouldShowAPlan() {
		assinaturas.plan().show("plano04");
	}
}
