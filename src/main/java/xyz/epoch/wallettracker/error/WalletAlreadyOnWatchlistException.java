package xyz.epoch.wallettracker.error;

public final class WalletAlreadyOnWatchlistException extends RuntimeException {

    private static final long serialVersionUID = 5861310537366287166L;

    public WalletAlreadyOnWatchlistException() {
        super();
    }

    public WalletAlreadyOnWatchlistException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public WalletAlreadyOnWatchlistException(final String message) {
        super(message);
    }

    public WalletAlreadyOnWatchlistException(final Throwable cause) {
        super(cause);
    }
}
