package devsu.clients.services.exceptions;

/**
 * ServiceException for gestion of exceptions for services
 */
public class ServiceException extends Exception {

    /**
     * Constructs a new ServiceException with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a call to {@link #initCause}.
     */
    public ServiceException() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructs a new ServiceException with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a call to {@link #initCause}.
     *
     * @param message The detail message (which is saved for later retrieval by the {@link #getMessage()} method).
     */
    public ServiceException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructs a new ServiceException with the specified cause and a detail message of
     * {@code (cause==null ? null : cause.toString())} (which typically contains the class and detail message of {@code cause}).
     * This constructor is useful for exceptions that are little more than wrappers for other throwables.
     *
     * @param cause The cause (which is saved for later retrieval by the {@link #getCause()} method). (A {@code null} value is permitted,
     *              and indicates that the cause is nonexistent or unknown.)
     */
    public ServiceException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }


    /**
     * Constructs a new ServiceException with the specified detail message and cause.
     * Note that the detail message associated with {@code cause} is not automatically incorporated in this exception's detail message.
     *
     * @param message The detail message (which is saved for later retrieval by the {@link #getMessage()} method).
     * @param cause   The cause (which is saved for later retrieval by the {@link #getCause()} method). (A {@code null} value is permitted,
     *                and indicates that the cause is nonexistent or unknown.)
     */
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructs a new ServiceException with the specified detail message, cause, suppression enabled or disabled, and writable stack trace enabled or disabled.
     *
     * @param message            The detail message.
     * @param cause              The cause. (A {@code null} value is permitted, and indicates that the cause is nonexistent or unknown.)
     * @param enableSuppression  Whether or not suppression is enabled or disabled.
     * @param writableStackTrace Regardless of whether the stack trace should be writable.
    */
    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }
}
