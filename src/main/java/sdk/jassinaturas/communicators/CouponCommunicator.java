package sdk.jassinaturas.communicators;

import feign.RequestLine;
import sdk.jassinaturas.clients.attributes.Coupon;

import javax.inject.Named;

public interface CouponCommunicator {

    @RequestLine("GET /coupons/{code}")
    Coupon show(@Named("code") String code);

    @RequestLine("POST /coupons")
    Coupon create(Coupon coupon);

    @RequestLine("PUT /coupons/{code}/active")
    Coupon activate(@Named("code") String code);

    @RequestLine("PUT /coupons/{code}/inactive")
    Coupon inactivate(@Named("code") String code);
}
