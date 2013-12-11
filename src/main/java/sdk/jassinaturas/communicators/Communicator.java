package sdk.jassinaturas.communicators;

import feign.Feign;
import feign.gson.GsonDecoder;

public class Communicator {
	
	
	public <T> T build(Class<T> clazz){
		return Feign
		.builder()
		.decoder(new GsonDecoder())
		.target(clazz,
				"https://sandbox.moip.com.br/assinaturas/v1");
	}
}
