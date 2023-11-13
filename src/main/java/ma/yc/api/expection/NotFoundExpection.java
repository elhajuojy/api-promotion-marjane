package ma.yc.api.expection;



public class NotFoundExpection extends RuntimeException {
    public NotFoundExpection(String message) {
        super(message);
    }
}
