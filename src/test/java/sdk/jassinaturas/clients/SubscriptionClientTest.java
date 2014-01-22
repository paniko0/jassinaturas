package sdk.jassinaturas.clients;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.GregorianCalendar;

import org.junit.Rule;
import org.junit.Test;

import sdk.jassinaturas.Assinaturas;
import sdk.jassinaturas.clients.attributes.Address;
import sdk.jassinaturas.clients.attributes.Authentication;
import sdk.jassinaturas.clients.attributes.BillingInfo;
import sdk.jassinaturas.clients.attributes.Country;
import sdk.jassinaturas.clients.attributes.CreditCard;
import sdk.jassinaturas.clients.attributes.State;
import sdk.jassinaturas.clients.attributes.Subscription;
import sdk.jassinaturas.clients.attributes.SubscriptionStatus;
import co.freeside.betamax.Betamax;
import co.freeside.betamax.MatchRule;
import co.freeside.betamax.Recorder;

public class SubscriptionClientTest {

    private final Assinaturas assinaturas = new Assinaturas(new Authentication("SGPA0K0R7O0IVLRPOVLJDKAWYBO1DZF3",
            "QUJESGM9JU175OGXRFRJIYM0SIFOMIFUYCBWH9WA"));

    @Rule
    public Recorder recorder = new Recorder();

    @Betamax(tape = "CREATE_SUBSCRIPTION",
            match = { MatchRule.body, MatchRule.method, MatchRule.headers, MatchRule.uri })
    @Test
    public void shouldCreateANewSubscription() {
        Subscription toBeCreated = new Subscription();
        toBeCreated
                .withCode("subscription_with_new_customer_00001")
                .withAmount(100)
                .withPlan(new Plan().withCode("plan001"))
                .withCustomer(
                        new Customer()
                                .withCode("customer_created_with_subscription_0001")
                                .withBirthdate(new GregorianCalendar(1989, GregorianCalendar.OCTOBER, 13))
                                .withCpf("12312312312")
                                .withEmail("teste@teste.com")
                                .withFullname("Danillo Souza")
                                .withPhoneAreaCode("11")
                                .withPhoneNumber("912341234")
                                .withAddress(
                                        new Address().withCity("São Paulo").withComplement("Apto")
                                                .withCountry(Country.BRA).withDistrict("Centro").withNumber("1000")
                                                .withState(State.SP).withStreet("9 de Julho").withZipcode("10012345"))
                                .withBillingInfo(
                                        new BillingInfo().withCreditCard(new CreditCard().withExpirationMonth("10")
                                                .withExpirationYear("18").withHolderName("Danillo Souza")
                                                .withNumber("4111111111111111"))));

        Subscription created = assinaturas.subscription().create(toBeCreated);

        assertEquals("Assinatura criada com sucesso", created.getMessage());
        assertFalse(created.hasAlerts());
        assertFalse(created.hasErrors());

        assertEquals(created.getAmount(), 100);
        assertEquals(created.getPlan().getName(), "Plano de Teste Atualizado");
        assertEquals(created.getPlan().getCode(), "plan001");
        assertEquals(created.getStatus(), SubscriptionStatus.ACTIVE);
        assertEquals(created.getInvoice().getAmount(), 1100);
        assertEquals(created.getInvoice().getId(), 12872);
        assertEquals(created.getInvoice().getStatus().getDescription(), "Atrasada");
        assertEquals(created.getInvoice().getStatus().getCode(), 5);
        assertEquals(created.getNextInvoiceDate().getDay(), 1);
        assertEquals(created.getNextInvoiceDate().getMonth(), 5);
        assertEquals(created.getNextInvoiceDate().getYear(), 2014);
        assertEquals(created.getCode(), "subscription_with_new_customer_00001");
        assertEquals(created.getCustomer().getEmail(), "teste@teste.com");
        assertEquals(created.getCustomer().getCode(), "customer_created_with_subscription_0001");
        assertEquals(created.getCustomer().getFullname(), "Danillo Souza");
    }

    @Betamax(tape = "CREATE_SUBSCRIPTION_WITHOUT_CUSTOMER", match = { MatchRule.body, MatchRule.method,
            MatchRule.headers, MatchRule.uri })
    @Test
    public void shouldCreateANewSubscriptionWithoutANewCustomer() {
        Subscription toBeCreated = new Subscription();
        toBeCreated.withCode("subscription00001").withAmount(100)
                .withCustomer(new Customer().withCode("customer000000001")).withPlan(new Plan().withCode("plan001"));

        Subscription created = assinaturas.subscription().create(toBeCreated);

        assertEquals("Assinatura criada com sucesso", created.getMessage());
        assertFalse(created.hasAlerts());
        assertFalse(created.hasErrors());

        assertEquals(created.getAmount(), 100);
        assertEquals(created.getPlan().getName(), "Plano de Teste Atualizado");
        assertEquals(created.getPlan().getCode(), "plan001");
        assertEquals(created.getStatus(), SubscriptionStatus.ACTIVE);
        assertEquals(created.getInvoice().getAmount(), 1100);
        assertEquals(created.getInvoice().getId(), 12873);
        assertEquals(created.getInvoice().getStatus().getDescription(), "Atrasada");
        assertEquals(created.getInvoice().getStatus().getCode(), 5);
        assertEquals(created.getNextInvoiceDate().getDay(), 1);
        assertEquals(created.getNextInvoiceDate().getMonth(), 5);
        assertEquals(created.getNextInvoiceDate().getYear(), 2014);
        assertEquals(created.getCode(), "subscription00001");
        assertEquals(created.getCustomer().getEmail(), "teste@teste.com");
        assertEquals(created.getCustomer().getCode(), "customer000000001");
        assertEquals(created.getCustomer().getFullname(), "Danillo Souza");
    }

    @Betamax(tape = "CREATE_SUBSCRIPTION_RETURNED_ERROR")
    @Test
    public void shouldReturnErrors() {
        Subscription toBeCreated = new Subscription();
        toBeCreated.withCode("subscription00001").withAmount(100)
                .withCustomer(new Customer().withCode("customer000000001")).withPlan(new Plan().withCode("plan001"));

        Subscription created = assinaturas.subscription().create(toBeCreated);

        assertEquals("Erro na requisição", created.getMessage());
        assertEquals("Código da assinatura já utilizado. Escolha outro código", created.getErrors().get(0)
                .getDescription());
        assertEquals("MA92", created.getErrors().get(0).getCode());
    }
}
