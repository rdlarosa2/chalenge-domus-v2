package domus.challenge.exceptions;

public class ValidateThresholdException extends RuntimeException {

    public ValidateThresholdException() {
        super();
    }


    public ValidateThresholdException(String message) {
        super(message);
    }

    public ValidateThresholdException(String message, Throwable cause) {
        super(message, cause);
    }


    public ValidateThresholdException(Throwable cause) {
        super(cause);
    }

}
