package sdk.jassinaturas.communicators;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import sdk.jassinaturas.exceptions.ApiResponseErrorException;
import sdk.jassinaturas.serializers.GsonDeserializer;
import feign.Response;
import feign.codec.ErrorDecoder;

public class ErrorHandler implements ErrorDecoder {

    @Override
    public Exception decode(final String arg0, final Response arg1) {

        try {
            InputStream is = arg1.body().asInputStream();
            Scanner s = new Scanner(is).useDelimiter("\\A");
            String json = s.hasNext() ? s.next() : "";
            GsonDeserializer gson = new GsonDeserializer();
            ApiResponseError error = gson.deserialize(json, ApiResponseError.class);
            throw new ApiResponseErrorException(error);
        } catch (IOException e) {
            System.out.println("Error when parsin response" + e);
        }

        return new ApiResponseErrorException("Http Status 400 happened");
    }
}
