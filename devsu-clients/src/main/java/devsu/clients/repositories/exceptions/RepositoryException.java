package devsu.clients.repositories.exceptions;
public class RepositoryException extends Exception {
    public RepositoryException() {

    }

    /**
     * Constructor RepositoryExceptions
     * @param message
     */
    public RepositoryException (String message) {
        super(message);
    }

    public RepositoryException(Throwable cause) {
        super(cause);

    }

    public RepositoryException(String message, Throwable cause) {
        super(message, cause);

    }

    public RepositoryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);

    }
}
