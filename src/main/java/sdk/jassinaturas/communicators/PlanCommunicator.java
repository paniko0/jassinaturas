package sdk.jassinaturas.communicators;

import javax.inject.Named;

import sdk.jassinaturas.clients.Plan;
import feign.Body;
import feign.Headers;
import feign.RequestLine;

public interface PlanCommunicator {
	
	@RequestLine("GET /plans/{code}")
	Plan show(@Named("code") String code);
	
	@RequestLine("GET /plans")
	Plan list();
	
	@RequestLine("POST /plans")
	@Headers("Content-Type: application/json")
	Plan create(Plan plan);
}
