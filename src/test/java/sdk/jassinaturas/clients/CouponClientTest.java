package sdk.jassinaturas.clients;

import co.freeside.betamax.Betamax;
import co.freeside.betamax.MatchRule;
import co.freeside.betamax.Recorder;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import sdk.jassinaturas.Assinaturas;
import sdk.jassinaturas.clients.attributes.Authentication;
import sdk.jassinaturas.clients.attributes.Coupon;
import sdk.jassinaturas.clients.attributes.CouponStatus;
import sdk.jassinaturas.clients.attributes.Discount;
import sdk.jassinaturas.clients.attributes.DiscountType;
import sdk.jassinaturas.clients.attributes.Duration;
import sdk.jassinaturas.clients.attributes.DurationType;
import sdk.jassinaturas.clients.attributes.ExpirationDate;
import sdk.jassinaturas.clients.attributes.Month;
import sdk.jassinaturas.communicators.SandboxCommunicator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CouponClientTest {

    private final Assinaturas assinaturas = new Assinaturas(new Authentication("SGPA0K0R7O0IVLRPOVLJDKAWYBO1DZF3",
            "QUJESGM9JU175OGXRFRJIYM0SIFOMIFUYCBWH9WA"), new SandboxCommunicator());

    @Rule
    public Recorder recorder = new Recorder();

    @Betamax(tape = "ACTIVATE_COUPON", match = { MatchRule.method, MatchRule.uri })
    @Test
    public void shouldActivateCoupon() throws Exception {
        Coupon coupon = assinaturas.coupons().activate("jassinaturas_coupon_01");

        assertEquals(CouponStatus.ACTIVE, coupon.getStatus());
    }

    @Betamax(tape = "INACTIVATE_COUPON", match = { MatchRule.method, MatchRule.uri })
    @Test
    public void shouldInactivateCoupon() throws Exception {
        Coupon coupon = assinaturas.coupons().activate("jassinaturas_coupon_01");

        assertEquals(CouponStatus.INACTIVE, coupon.getStatus());
    }

    @Betamax(tape = "CREATE_COUPON", match = { MatchRule.body, MatchRule.method, MatchRule.uri })
    @Test
    public void createCoupon() {
        Coupon toBeCreated = new Coupon();

        toBeCreated.withCode("jassinaturas_coupon_01")
                .withName("JAssinaturas")
                .withDescription("Coupon for test control")
                .withDiscount(new Discount()
                                .withValue(1000)
                                .withType(DiscountType.PERCENT))
                .withStatus(CouponStatus.ACTIVE)
                .withDuration(new Duration()
                        .withType(DurationType.REPEATING)
                        .withOccurrences(1))
                .withExpirationDate(new ExpirationDate()
                        .withDay(10)
                        .withMonth(Month.OCTOBER)
                        .withYear(2020))
                .withMaxRedemptions(1000);

        Coupon coupon = assinaturas.coupons().create(toBeCreated);

        assertEquals("jassinaturas_coupon_01", coupon.getCode());
        assertEquals("JAssinaturas", coupon.getName());
        assertEquals("Coupon for test control", coupon.getDescription());
        assertEquals(1000, coupon.getDiscount().getValue());
        assertEquals(DiscountType.PERCENT, coupon.getDiscount().getType());
        assertEquals(CouponStatus.ACTIVE, coupon.getStatus());
        assertEquals(DurationType.REPEATING, coupon.getDuration().getType());
        assertEquals(1, coupon.getDuration().getOccurrences());
        assertEquals(10, coupon.getExpirationDate().getDay());
        assertEquals(Month.OCTOBER, coupon.getExpirationDate().getMonth());
        assertEquals(2020, coupon.getExpirationDate().getYear());
        assertEquals(1000, coupon.getMaxRedemptions().intValue());
        assertFalse(coupon.inUse());
        assertEquals(21, coupon.getCreationDate().getDay());
        assertEquals(Month.JUNE, coupon.getCreationDate().getMonth());
        assertEquals(2015, coupon.getCreationDate().getYear());
        assertEquals(21, coupon.getCreationDate().getHour());
        assertEquals(51, coupon.getCreationDate().getMinute());
        assertEquals(43, coupon.getCreationDate().getSecond());
    }
}
