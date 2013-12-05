package sdk.jassinaturas.communicators;

import javax.inject.Named;

import sdk.jassinaturas.clients.Plan;
import feign.Headers;
import feign.RequestLine;

public interface PlanCommunicator {
	@RequestLine("GET /plans/{code}")
	@Headers(value = "Authorization: Basic U0dQQTBLMFI3TzBJVkxSUE9WTEpES0FXWUJPMURaRjM6UVVKRVNHTTlKVTE3NU9HWFJGUkpJWU0wU0lGT01JRlVZQ0JXSDlXQQ==")
	Plan contributors(@Named("code") String code);
}
