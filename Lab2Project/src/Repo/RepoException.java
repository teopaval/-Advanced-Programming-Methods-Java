package Repo;

/**
 * Created by teo on 11/3/2016.
 */
public class RepoException extends Exception {

    public RepoException() {
        super();
    }

    public RepoException(String message) {
        super(message);
    }

    public RepoException(String message, Throwable cause) {
        super(message, cause);
    }

    public RepoException(Throwable cause) {
        super(cause);
    }

    protected RepoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
