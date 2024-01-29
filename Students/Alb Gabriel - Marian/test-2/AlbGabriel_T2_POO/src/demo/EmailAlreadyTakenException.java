package demo;

public class EmailAlreadyTakenException extends RuntimeException{
    public EmailAlreadyTakenException(String msj){
        super(msj);
    }
}
