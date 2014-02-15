package sdk.jassinaturas.clients;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Rule;
import org.junit.Test;

import sdk.jassinaturas.Assinaturas;
import sdk.jassinaturas.clients.attributes.Authentication;
import sdk.jassinaturas.clients.attributes.Invoice;
import co.freeside.betamax.Betamax;
import co.freeside.betamax.MatchRule;
import co.freeside.betamax.Recorder;

public class InvoiceClientTest {

    private final Assinaturas assinaturas = new Assinaturas(new Authentication("SGPA0K0R7O0IVLRPOVLJDKAWYBO1DZF3",
            "QUJESGM9JU175OGXRFRJIYM0SIFOMIFUYCBWH9WA"));

    @Rule
    public Recorder recorder = new Recorder();

    @Betamax(tape = "GET_SINGLE_INVOICE", match = { MatchRule.method, MatchRule.headers, MatchRule.uri })
    @Test
    public void shouldShowAInvoice() {
        Invoice invoice = assinaturas.invoice().show(12872);

        assertEquals(0, invoice.getCreationDate().get(Calendar.MINUTE));
        assertEquals(28, invoice.getCreationDate().get(Calendar.SECOND));
        assertEquals(Calendar.JANUARY, invoice.getCreationDate().get(Calendar.MONTH));
        assertEquals(2014, invoice.getCreationDate().get(Calendar.YEAR));
        assertEquals(23, invoice.getCreationDate().get(Calendar.HOUR_OF_DAY));
        assertEquals(21, invoice.getCreationDate().get(Calendar.DAY_OF_MONTH));

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
}
