package sdk.jassinaturas.exceptions;

public class ApiResponseErrorException extends RuntimeException {

    private static final long serialVersionUID = -5037934610970014201L;

    public ApiResponseErrorException() {
        super();
    }

    public ApiResponseErrorException(final String message) {
        super(message);
    }

    public ApiResponseErrorException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ApiResponseErrorException(final String message, final Throwable cause, final boolean enableSuppression,
            final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ApiResponseErrorException(final Throwable cause) {
        super(cause);
    }

}
