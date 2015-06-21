package sdk.jassinaturas.communicators;

import feign.RequestLine;
import sdk.jassinaturas.clients.attributes.Coupon;

import javax.inject.Named;

public interface CouponCommunicator {

    @RequestLine("GET /coupons/{code}")
    Coupon show(@Named("code") String code);

    @RequestLine("POST /coupons")
    Coupon create(Coupon coupon);
}
