package sdk.jassinaturas.communicators;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import sdk.jassinaturas.exceptions.ApiResponseErrorException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class ErrorHandling implements ErrorDecoder {

    @Override
    public Exception decode(final String arg0, final Response arg1) {

        try {
            InputStream is = arg1.body().asInputStream();
            Scanner s = new Scanner(is).useDelimiter("\\A");
            throw new ApiResponseErrorException(s.hasNext() ? s.next() : "");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ApiResponseErrorException("Http Status 400 happened");
    }
}
