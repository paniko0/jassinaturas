package sdk.jassinaturas.clients;

import org.junit.Rule;
import org.junit.Test;

import co.freeside.betamax.Betamax;
import co.freeside.betamax.Recorder;

public class PlanTest {

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
		Plan.show("plano04");
	}
}
