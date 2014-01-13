package sdk.jassinaturas.communicators;

import javax.inject.Named;

import sdk.jassinaturas.clients.Plan;
import feign.Headers;
import feign.RequestLine;

public interface PlanCommunicator {

    @RequestLine("PUT /plans/{code}/activate")
    @Headers({ "Content-Type: application/json; charset=utf-8", "Accept: application/json", "Accept-Encoding: utf-8",
            "Accept-Charset: utf-8" })
    Plan activate(@Named("code") String code);

    @RequestLine("POST /plans")
    @Headers({ "Content-Type: application/json; charset=utf-8", "Accept-Encoding: utf-8" })
    Plan create(Plan plan);

    @RequestLine("PUT /plans/{code}/inactivate")
    @Headers({ "Content-Type: application/json; charset=utf-8", "Accept: application/json", "Accept-Encoding: utf-8",
            "Accept-Charset: utf-8" })
    Plan inactivate(@Named("code") String code);

    @RequestLine("GET /plans")
    @Headers({ "Content-Type: application/json; charset=utf-8", "Accept: application/json", "Accept-Encoding: utf-8",
            "Accept-Charset: utf-8" })
    Plan list();

    @RequestLine("GET /plans/{code}")
    Plan show(@Named("code") String code);

    @RequestLine("PUT /plans/{code}")
    @Headers({ "Content-Type: application/json; charset=utf-8", "Accept: application/json", "Accept-Encoding: utf-8",
            "Accept-Charset: utf-8" })
    Plan update(@Named("code") String code, Plan plan);
}
