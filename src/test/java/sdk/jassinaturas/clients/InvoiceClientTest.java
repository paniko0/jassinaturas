package sdk.jassinaturas.clients;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;

import sdk.jassinaturas.Assinaturas;
import sdk.jassinaturas.clients.attributes.Authentication;
import sdk.jassinaturas.clients.attributes.Invoice;
import sdk.jassinaturas.clients.attributes.Month;
import sdk.jassinaturas.clients.attributes.Payment;
import sdk.jassinaturas.communicators.SandboxCommunicator;
import co.freeside.betamax.Betamax;
import co.freeside.betamax.MatchRule;
import co.freeside.betamax.Recorder;

public class InvoiceClientTest {

    private final Assinaturas assinaturas = new Assinaturas(new Authentication("SGPA0K0R7O0IVLRPOVLJDKAWYBO1DZF3",
            "QUJESGM9JU175OGXRFRJIYM0SIFOMIFUYCBWH9WA"), new SandboxCommunicator());

    @Rule
    public Recorder recorder = new Recorder();

    @Betamax(tape = "GET_PAYMENTS_FROM_INVOICE", match = { MatchRule.method, MatchRule.uri })
    @Test
    public void shouldGetPaymentsFromAInvoice() {
        List<Payment> payments = assinaturas.invoices().payments(12872);
        Payment payment = payments.get(0);

        assertEquals(14811, payment.getId());
        assertEquals(1390352428, payment.getMoipId());

        assertEquals("Cancelado", payment.getStatus().getDescription());
        assertEquals(5, payment.getStatus().getCode());

        assertEquals(0, payment.getCreationDate().getMinute());
        assertEquals(28, payment.getCreationDate().getSecond());
        assertEquals(Month.JANUARY, payment.getCreationDate().getMonth());
        assertEquals(2014, payment.getCreationDate().getYear());
        assertEquals(23, payment.getCreationDate().getHour());
        assertEquals(21, payment.getCreationDate().getDay());

        assertEquals("Cartão de Crédito", payment.getPaymentMethod().getDescription());
        assertEquals(1, payment.getPaymentMethod().getCode());
        assertEquals("Danillo Souza", payment.getPaymentMethod().getCreditCard().getHolderName());
        assertEquals("411111", payment.getPaymentMethod().getCreditCard().getFirstSixDigits());
        assertEquals("1111", payment.getPaymentMethod().getCreditCard().getLastFourDigits());
        assertEquals("10", payment.getPaymentMethod().getCreditCard().getExpirationMonth());
        assertEquals("18", payment.getPaymentMethod().getCreditCard().getExpirationYear());
        assertEquals("VISA", payment.getPaymentMethod().getCreditCard().getBrand());

    }

    @Betamax(tape = "GET_SINGLE_INVOICE", match = { MatchRule.method, MatchRule.uri })
    @Test
    public void shouldShowAInvoice() {
        Invoice invoice = assinaturas.invoices().show(12872);

        assertEquals(0, invoice.getCreationDate().getMinute());
        assertEquals(28, invoice.getCreationDate().getSecond());
        assertEquals(Month.JANUARY, invoice.getCreationDate().getMonth());
        assertEquals(2014, invoice.getCreationDate().getYear());
        assertEquals(23, invoice.getCreationDate().getHour());
        assertEquals(21, invoice.getCreationDate().getDay());

        assertEquals(1100, invoice.getAmount());
        assertEquals("subscription_with_new_customer_00001", invoice.getSubscriptionCode());
        assertEquals(1, invoice.getOccurrence());

        assertEquals("Atrasada", invoice.getStatus().getDescription());
        assertEquals(5, invoice.getStatus().getCode());

        assertEquals("Plano de Teste Atualizado", invoice.getPlan().getName());
        assertEquals("plan001", invoice.getPlan().getCode());

        assertEquals("Valor da assinatura", invoice.getItems().get(0).getType());
        assertEquals(100, invoice.getItems().get(0).getAmount());
        assertEquals("Taxa de contratação", invoice.getItems().get(1).getType());
        assertEquals(1000, invoice.getItems().get(1).getAmount());

        assertEquals("Danillo Souza", invoice.getCustomer().getFullname());
        assertEquals("customer_created_with_subscription_0001", invoice.getCustomer().getCode());
    }

    @Betamax(tape = "RETRY_INVOICE", match = { MatchRule.method, MatchRule.uri })
    @Test
    public void shouldRetryAInvoice() {
        Invoice invoice = assinaturas.invoices().retry(14606);

        // There isn't any response from Moip Assinaturas when invoice have been
        // retried
        // So, I didn't do any assert
    }

    @Betamax(tape = "GET_SINGLE_INVOICE", match = { MatchRule.method, MatchRule.headers, MatchRule.uri })
    @Test
    public void shouldGetResultFromToString() {
        String invoice = assinaturas.invoices().show(12872).toString();

        assertEquals(
                "Invoice [amount=1100, creationDate=CreationDate [day=21, hour=23, minute=0, month=1, second=28, year=2014], customer=Customer [address=null, billingInfo=null, birthdate=null, code=customer_created_with_subscription_0001, cpf=null, customers=null, email=null, fullname=Danillo Souza, message=null, phoneAreaCode=null, phoneNumber=null, birthdateDay=0, birthdateMonth=0, birthdateYear=0], id=12872, items=[Item [amount=100, type=Valor da assinatura], Item [amount=1000, type=Taxa de contratação]], occurrence=1, payments=null, plan=Plan [alerts=null, amount=0, billingCycles=0, code=plan001, description=null, interval=null, maxQty=0, message=null, name=Plano de Teste Atualizado, plans=null, setupFee=0, status=null, trial=null], status=InvoiceStatus [code=5, description=Atrasada], subscriptionCode=subscription_with_new_customer_00001]",
                invoice);

    }
}
