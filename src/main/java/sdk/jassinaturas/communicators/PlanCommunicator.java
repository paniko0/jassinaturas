package sdk.jassinaturas.communicators;

import javax.inject.Named;

import sdk.jassinaturas.clients.Plan;
import feign.Headers;
import feign.RequestLine;

public interface PlanCommunicator {
	
	@RequestLine("GET /plans/{code}")
	Plan show(@Named("code") String code);
	
	@RequestLine("GET /plans")
	@Headers({"Content-Type: application/json; charset=utf-8", "Accept: application/json", "Accept-Encoding: utf-8", "Accept-Charset: utf-8" })
	Plan list();
	
	@RequestLine("POST /plans")
	@Headers({"Content-Type: application/json; charset=utf-8", "Accept-Encoding: utf-8"})
	Plan create(Plan plan);
	
	@RequestLine("PUT /plans/{code}")
	@Headers({"Content-Type: application/json; charset=utf-8", "Accept: application/json", "Accept-Encoding: utf-8", "Accept-Charset: utf-8" })
	Plan update(@Named("code") String code, Plan plan);
}
