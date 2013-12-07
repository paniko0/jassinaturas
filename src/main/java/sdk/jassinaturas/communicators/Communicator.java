package sdk.jassinaturas.communicators;

import feign.Feign;
import feign.gson.GsonDecoder;

public class Communicator<T> {
	
	T type;	
	
	public T build(Class<T> clazz){
		return Feign
		.builder()
		.decoder(new GsonDecoder())
		.target(clazz,
				"https://sandbox.moip.com.br/assinaturas/v1");
	}
	
	public T getType() {
		return type;
	}
	
	public void setType(T type) {
		this.type = type;
	}
}
