package devsu.clients.rest.exceptions;

public class NotContentException extends Exception {
    public NotContentException() {
        super();
    }

    public NotContentException(String message) {
        super(message);
    }

    public NotContentException(Throwable cause) {
        super(cause);
    }

    public NotContentException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotContentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
