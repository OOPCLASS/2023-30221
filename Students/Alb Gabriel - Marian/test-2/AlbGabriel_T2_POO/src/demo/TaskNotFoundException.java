package demo;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(String msj, Throwable cause) {
        super(msj, cause);
    }

    public TaskNotFoundException(String message) {
        super(message);
    }


}

