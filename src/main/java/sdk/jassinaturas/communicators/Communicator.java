package sdk.jassinaturas.communicators;

import sdk.jassinaturas.clients.attributes.Authentication;

public interface Communicator {

    public <T> T build(final Class<T> clazz, final Authentication authentication);

}
