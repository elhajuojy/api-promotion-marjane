package ma.yc.api.exceptions.techincal;


import ma.yc.api.exceptions.business.AlreadyExsitsException;
import ma.yc.api.exceptions.business.BadRequestExcpetion;
import ma.yc.api.exceptions.business.NotFoundException;
import ma.yc.api.exceptions.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExpectionHandler extends ResponseEntityExceptionHandler {




    @ExceptionHandler({
            AlreadyExsitsException.class,
            NotFoundException.class,
            BadRequestExcpetion.class

    })
    public ResponseEntity<Object> handleAlreadyExistsAndBadRequestExceptions (AlreadyExsitsException exception){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode("400");
        errorResponse.setStatus(HttpStatus.BAD_REQUEST);
        errorResponse.setMessage(exception.getMessage());
        return buildResponseEntity(errorResponse);
    }



    private ResponseEntity<Object> buildResponseEntity(ErrorResponse errorRes) {
        return new ResponseEntity<>(errorRes, errorRes.getStatus());
    }
}
