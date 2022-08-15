package xyz.epoch.wallettracker.error;


public final class NoNewTransactionException extends RuntimeException {

    private static final long serialVersionUID = 5861310537366287172L;

    public NoNewTransactionException() {
        super();
    }

    public NoNewTransactionException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public NoNewTransactionException(final String message) {
        super(message);
    }

    public NoNewTransactionException(final Throwable cause) {
        super(cause);
    }
}