package be.umons.pgl_gestionCour_back_end.exception;

public class CustomException extends RuntimeException{

    private String message;
    public CustomException(String message) {

        super(message);
        this.message = message;
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
