package sdk.jassinaturas.clients.attributes;


public class Authentication {
    private String secret;
    private String token;

    public Authentication(final String token, final String secret) {
        this.token = token;
        this.secret = secret;
    }

    public String getSecret() {
        return secret;
    }

    public String getToken() {
        return token;
    }

    public void setSecret(final String secret) {
        this.secret = secret;
    }

    public void setToken(final String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Authentication [token=" + token + ", secret=" + secret + "]";
    }
}
