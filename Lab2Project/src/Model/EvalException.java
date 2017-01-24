package Model;

/**
 * Created by teo on 12/16/2016.
 */
public class EvalException extends Exception {
    public EvalException() {
        super();
    }

    public EvalException(String message) {
        super(message);
    }

    public EvalException(String message, Throwable cause) {
        super(message, cause);
    }

    public EvalException(Throwable cause) {
        super(cause);
    }

    protected EvalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
