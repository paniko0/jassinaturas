package sdk.jassinaturas.clients;

import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import sdk.jassinaturas.Assinaturas;
import sdk.jassinaturas.clients.attributes.Authentication;
import sdk.jassinaturas.clients.attributes.Interval;
import sdk.jassinaturas.clients.attributes.PlanStatus;
import sdk.jassinaturas.clients.attributes.Trial;
import sdk.jassinaturas.clients.attributes.Unit;
import co.freeside.betamax.Betamax;
import co.freeside.betamax.MatchRule;
import co.freeside.betamax.Recorder;

public class PlanTest {
	
//	private Assinaturas assinaturas = new Assinaturas(new Authentication("123", "abc"));
	private Assinaturas assinaturas = new Assinaturas(new Authentication("SGPA0K0R7O0IVLRPOVLJDKAWYBO1DZF3", "QUJESGM9JU175OGXRFRJIYM0SIFOMIFUYCBWH9WA"));

	@Rule
	public Recorder recorder = new Recorder();

	@Betamax(tape = "CREATE_PLAN", match = { MatchRule.body, MatchRule.method, MatchRule.headers } )
	@Test
	public void shouldCreateANewPlan() {
		Plan toCreate = new Plan();
		toCreate
				.withCode("plan001")
				.withDescription("Plano de Teste")
				.withName("Plano de Teste")
				.withAmount(1000)
				.withSetupFee(100)
				.withBillingCycles(1)
				.withPlanStatus(PlanStatus.ACTIVE)
				.withMaxQty(10)
				.withInterval(new Interval()
									.withLength(10)
									.withUnit(Unit.MONTH))
				.withTrial(new Trial()
									.withDays(10)
									.enabled());
		
		
		Plan created = assinaturas.plan().create(toCreate);
		
		Assert.assertEquals("Plano criado com sucesso", created.getMessage());
		Assert.assertFalse(created.hasAlerts());
		Assert.assertFalse(created.hasErrors());
	}

	@Betamax(tape = "UPDATE_PLAN", match = { MatchRule.body, MatchRule.method, MatchRule.headers } )
	@Test
	public void shouldUpdateAPlan() {
		Plan toUpdate = new Plan();
		toUpdate
				.withCode("plan001")
				.withDescription("Plano de Teste Atualizado")
				.withName("Plano de Teste Atualizado")
				.withAmount(10000)
				.withSetupFee(1000)
				.withBillingCycles(10)
				.withPlanStatus(PlanStatus.INACTIVE)
				.withMaxQty(100)
				.withInterval(new Interval()
									.withLength(100)
									.withUnit(Unit.DAY))
				.withTrial(new Trial()
									.withDays(5)
									.disabled());
		
		
		Plan plan = assinaturas.plan().update(toUpdate);
		
		// There isn't any response from Moip Assinaturas when plan is updated
		// So, I didn't do any assert
		
	}

	@Betamax(tape = "LIST_ALL_PLANS", match = { MatchRule.method, MatchRule.headers } )
	@Test
	public void shouldListAllPlans() {
		List<Plan> plans = assinaturas.plan().list();
		Assert.assertEquals(7, plans.size());
	}

	@Betamax(tape = "GET_SINGLE_PLAN", match = { MatchRule.method, MatchRule.headers } )
	@Test
	public void shouldShowAPlan() {
		Plan plan = assinaturas.plan().show("plan001");
		
		Assert.assertEquals("plan001", plan.getCode());
		Assert.assertEquals("Plano de Teste Atualizado", plan.getDescription());
		Assert.assertEquals("Plano de Teste Atualizado", plan.getName());
		Assert.assertEquals(10000, plan.getAmount());
		Assert.assertEquals(1000, plan.getSetupFee());
		Assert.assertEquals(10, plan.getBillingCycles());
		Assert.assertEquals(PlanStatus.INACTIVE, plan.getStatus());
		Assert.assertEquals(100, plan.getMaxQuantity());
		Assert.assertEquals(100, plan.getInterval().getLength());
		Assert.assertEquals(Unit.DAY, plan.getInterval().getUnit());
		Assert.assertFalse(plan.getTrial().isEnabled());
		Assert.assertEquals(5, plan.getTrial().getDays());
	}
}
