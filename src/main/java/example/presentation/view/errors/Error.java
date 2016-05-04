package example.presentation.view.errors;

import org.springframework.validation.FieldError;

public class Error {
    public ErrorType type ;
    public String message ;

    public Error( ErrorType type , String message) {
        this.type = type;
        this.message = message;
    }

    public Error( FieldError error ) {
        this.type = ErrorType.FieldError;
        this.message = String.format("field = '%s' : rejected value = '%s' : %s", error.getField(), error.getRejectedValue(), error.getDefaultMessage());
    }
}
