package ma.yc.api.exceptions.business;

public class OutOfTimeExpection extends RuntimeException{

    public OutOfTimeExpection(String message) {
        super(message);
    }
}
