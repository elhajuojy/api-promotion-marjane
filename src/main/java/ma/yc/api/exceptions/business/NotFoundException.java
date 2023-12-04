package ma.yc.api.exceptions.business;

public class NotFoundException extends RuntimeException{

        private static final long serialVersionUID = 5391146990874781853L;

        public NotFoundException(String message) {
            super(message);
        }
}
