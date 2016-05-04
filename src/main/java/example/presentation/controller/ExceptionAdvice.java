package example.presentation.controller;

import example.presentation.view.errors.ErrorType;
import example.presentation.view.errors.Errors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionAdvice {


    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
        MissingServletRequestParameterException.class,
            IllegalArgumentException.class
    })
    @ResponseBody
    public Errors missing(Exception exception) {
        ErrorType type = ErrorType.BadRequest;
        log(type, exception);
        return new Errors( type, exception);
    }

    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class )
    @ResponseBody
    public Errors invalid(BindException exception) {
        return bindingError(exception, exception.getBindingResult());
    }

    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class )
    @ResponseBody
    public Errors invalid(MethodArgumentNotValidException exception) {
        return bindingError(exception, exception.getBindingResult());
    }

    private Errors bindingError(Exception exception, BindingResult bindingResult) {
        ErrorType type = ErrorType.FieldError;
        log(type, exception);
        return new Errors(bindingResult.getFieldErrors());
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    public Errors notFound(Exception exception) {
        ErrorType type = ErrorType.NotFound;
        log(type, exception);
        return new Errors(type, exception);
    }

    static private final Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);

    private void log(ErrorType type, Exception exception) {
        logger.error( "Status = " + type + " : " + exception.toString() );
    }
}
