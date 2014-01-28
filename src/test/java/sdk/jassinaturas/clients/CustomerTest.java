package sdk.jassinaturas.clients;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;

import sdk.jassinaturas.Assinaturas;
import sdk.jassinaturas.clients.attributes.Address;
import sdk.jassinaturas.clients.attributes.Authentication;
import sdk.jassinaturas.clients.attributes.BillingInfo;
import sdk.jassinaturas.clients.attributes.Country;
import sdk.jassinaturas.clients.attributes.CreditCard;
import sdk.jassinaturas.clients.attributes.Customer;
import sdk.jassinaturas.clients.attributes.State;
import sdk.jassinaturas.exceptions.ApiResponseErrorException;
import co.freeside.betamax.Betamax;
import co.freeside.betamax.MatchRule;
import co.freeside.betamax.Recorder;

public class CustomerTest {

    private final Assinaturas assinaturas = new Assinaturas(new Authentication("SGPA0K0R7O0IVLRPOVLJDKAWYBO1DZF3",
            "QUJESGM9JU175OGXRFRJIYM0SIFOMIFUYCBWH9WA"));

    @Rule
    public Recorder recorder = new Recorder();

    @Betamax(tape = "CREATE_CUSTOMER", match = { MatchRule.body, MatchRule.method, MatchRule.headers })
    @Test
    public void shouldCreateANewCustomer() {
        Customer toCreate = new Customer();
        toCreate.withCode("customer000000001")
                .withBirthdate(new GregorianCalendar(1989, GregorianCalendar.OCTOBER, 13))
                .withCpf("12312312312")
                .withEmail("teste@teste.com")
                .withFullname("Danillo Souza")
                .withPhoneAreaCode("11")
                .withPhoneNumber("912341234")
                .withAddress(
                        new Address().withCity("São Paulo").withComplement("Apto").withCountry(Country.BRA)
                                .withDistrict("Centro").withNumber("1000").withState(State.SP).withStreet("9 de Julho")
                                .withZipcode("10012345"))
                .withBillingInfo(
                        new BillingInfo().withCreditCard(new CreditCard().withExpirationMonth("10")
                                .withExpirationYear("18").withHolderName("Danillo Souza")
                                .withNumber("4111111111111111")));

        Customer created = assinaturas.customer().create(toCreate);

        assertEquals("Cliente criado com sucesso", created.getMessage());
        assertFalse(created.hasAlerts());
    }

    @Betamax(tape = "CREATE_CUSTOMER_WITHOUT_CREDITCARD",
            match = { MatchRule.body, MatchRule.method, MatchRule.headers })
    @Test
    public void shouldCreateANewCustomerWithoutCreditCard() {
        Customer toCreate = new Customer();
        toCreate.withCode("customer000000001_no_creditCard")
                .withBirthdate(new GregorianCalendar(1989, GregorianCalendar.OCTOBER, 13))
                .withCpf("12312312312")
                .withEmail("teste@teste.com")
                .withFullname("Danillo Souza")
                .withPhoneAreaCode("11")
                .withPhoneNumber("912341234")
                .withAddress(
                        new Address().withCity("São Paulo").withComplement("Apto").withCountry(Country.BRA)
                                .withDistrict("Centro").withNumber("1000").withState(State.SP).withStreet("9 de Julho")
                                .withZipcode("10012345"));

        Customer created = assinaturas.customer().create(toCreate);

        assertEquals("Cliente criado com sucesso", created.getMessage());
        assertFalse(created.hasAlerts());
    }

    @Betamax(tape = "LIST_ALL_CUSTOMERS", match = { MatchRule.method, MatchRule.headers })
    @Test
    public void shouldListAllCustomers() {
        List<Customer> customers = assinaturas.customer().list();
        assertEquals(9, customers.size());
        assertEquals(1, customers.get(0).getBirthdateMonth());
        assertEquals(18, customers.get(0).getBirthdateDay());
        assertEquals(2014, customers.get(0).getBirthdateYear());
        assertEquals("11", customers.get(0).getPhoneAreaCode());
        assertEquals("912341234", customers.get(0).getPhoneNumber());
        assertEquals("teste@teste.com", customers.get(0).getEmail());
        assertEquals("12312312312", customers.get(0).getCpf());
        assertEquals("customer0001", customers.get(0).getCode());
        assertEquals("Danillo Souza", customers.get(0).getFullname());
    }

    @Betamax(tape = "CREATE_CUSTOMER_RETURNED_ERROR")
    @Test
    public void shouldReturnErrors() {
        Customer toCreate = new Customer();
        toCreate.withCode("customer000000001_no_creditCard")
                .withBirthdate(new GregorianCalendar(1989, GregorianCalendar.OCTOBER, 13))
                .withCpf("12312312312")
                .withEmail("teste@teste.com")
                .withFullname("Danillo Souza")
                .withPhoneAreaCode("11")
                .withPhoneNumber("912341234")
                .withAddress(
                        new Address().withCity("São Paulo").withComplement("Apto").withCountry(Country.BRA)
                                .withDistrict("Centro").withNumber("1000").withState(State.SP).withStreet("9 de Julho")
                                .withZipcode("10012345"));

        try {
            Customer created = assinaturas.customer().create(toCreate);
            fail("Should return error");
        } catch (ApiResponseErrorException e) {
            assertEquals("Erro na requisição", e.getApiResponseError().getMessage());
            assertEquals("Código do cliente já utilizado. Escolha outro código.", e.getApiResponseError().getErrors()
                    .get(0).getDescription());
            assertEquals("MA33", e.getApiResponseError().getErrors().get(0).getCode());
        }

    }

    @Betamax(tape = "GET_SINGLE_CUSTOMER", match = { MatchRule.method, MatchRule.headers })
    @Test
    public void shouldShowACustomer() {
        Customer customer = assinaturas.customer().show("customer000000001");

        assertEquals("customer000000001", customer.getCode());
        assertEquals("Danillo Souza", customer.getFullname());
        assertEquals("teste@teste.com", customer.getEmail());
        assertEquals("12312312312", customer.getCpf());
        assertEquals("11", customer.getPhoneAreaCode());
        assertEquals("912341234", customer.getPhoneNumber());
        assertEquals(10, customer.getBirthdateMonth());
        assertEquals(13, customer.getBirthdateDay());
        assertEquals(1989, customer.getBirthdateYear());
        assertEquals("9 de Julho", customer.getAddress().getStreet());
        assertEquals("1000", customer.getAddress().getNumber());
        assertEquals("Apto", customer.getAddress().getComplement());
        assertEquals("Centro", customer.getAddress().getDistrict());
        assertEquals("São Paulo", customer.getAddress().getCity());
        assertEquals("SP", customer.getAddress().getState().toString());
        assertEquals("BRA", customer.getAddress().getCountry().toString());
        assertEquals("10012345", customer.getAddress().getZipcode());
        assertEquals("VISA", customer.getBillingInfo().getCreditCards().get(0).getBrand());
        assertEquals("411111", customer.getBillingInfo().getCreditCards().get(0).getFirstSixDigits());
        assertEquals("1111", customer.getBillingInfo().getCreditCards().get(0).getLastFourDigits());
        assertEquals("10", customer.getBillingInfo().getCreditCards().get(0).getExpirationMonth());
        assertEquals("18", customer.getBillingInfo().getCreditCards().get(0).getExpirationYear());
        assertEquals("Danillo Souza", customer.getBillingInfo().getCreditCards().get(0).getHolderName());
        assertEquals("teste-teste00-1teste-t35t3-139015", customer.getBillingInfo().getCreditCards().get(0).getVault());

    }

    @Betamax(tape = "UPDATE_CREDITCARD", match = { MatchRule.body, MatchRule.method, MatchRule.headers })
    @Test
    public void shouldUpdateACreditCard() {
        Customer toUpdate = new Customer();
        toUpdate.withCode("customer0001_toBeUpdated").withBillingInfo(
                new BillingInfo().withCreditCard(new CreditCard().withExpirationMonth("10").withExpirationYear("18")
                        .withHolderName("Danillo Souza").withNumber("4111111111111111")));

        Customer updated = assinaturas.customer().updateVault(toUpdate);

        assertEquals("Dados alterados com sucesso", updated.getMessage());
        assertFalse(updated.hasAlerts());

    }

    @Betamax(tape = "UPDATE_CUSTOMER", match = { MatchRule.body, MatchRule.method, MatchRule.headers })
    @Test
    public void shouldUpdateACustomer() {
        Customer toUpdate = new Customer();
        toUpdate.withCode("customer0001_toBeUpdated")
                .withBirthdate(new GregorianCalendar(1989, GregorianCalendar.OCTOBER, 13))
                .withCpf("32132132132")
                .withEmail("etset@etset.com")
                .withFullname("Souza Danillo")
                .withPhoneAreaCode("11")
                .withPhoneNumber("912341234")
                .withAddress(
                        new Address().withCity("São Paulo").withComplement("Apto").withCountry(Country.BRA)
                                .withDistrict("Centro").withNumber("1000").withState(State.SP).withStreet("9 de Julho")
                                .withZipcode("10012345"));

        Customer created = assinaturas.customer().update(toUpdate);

        // There isn't any response from Moip Assinaturas when plan is activated
        // So, I didn't do any assert

    }
}
