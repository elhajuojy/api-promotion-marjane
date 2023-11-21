package ma.yc.api.exceptions.business;

public class BadRequestExcpetion extends RuntimeException{

    public BadRequestExcpetion(String message){
        super(message);
    }
}
