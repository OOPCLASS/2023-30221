package demo;

public  class ProjectNotFoundException extends RuntimeException{
    public ProjectNotFoundException(String msj){
        super(msj);
    }
}