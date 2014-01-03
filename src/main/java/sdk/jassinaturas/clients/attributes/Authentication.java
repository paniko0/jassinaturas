package sdk.jassinaturas.clients.attributes;

import feign.auth.BasicAuthRequestInterceptor;

public class Authentication {
	private String token;
	private String secret;
	
	public Authentication(String token, String secret) {
		this.token = token;
		this.secret = secret;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public String getSecret() {
		return secret;
	}
	
	public void setSecret(String secret) {
		this.secret = secret;
	}

	@Override
	public String toString() {
		return "Authentication [token=" + token + ", secret=" + secret + "]";
	}
}
