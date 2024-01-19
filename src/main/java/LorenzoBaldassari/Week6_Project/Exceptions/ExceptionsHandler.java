//package LorenzoBaldassari.Week6_Project.Exceptions;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestControllerAdvice
//public class ExceptionsHandler {
//    @ExceptionHandler(BadRequestException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ErrorPayload badRequestMethod(BadRequestException ex){
//        List<String> errorList =new ArrayList<>();
//        ex.getObjectErrorlist().stream().forEach(elem->{
//            errorList.add(elem.getDefaultMessage());
//        });
//        return new ErrorPayload("errore Bad Request "+ex.getObjectErrorlist());
//    }
//    @ExceptionHandler({ItemNotFoundException.class})
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ErrorPayload itemNotFoundMethod(ItemNotFoundException ex ){
//        return new ErrorPayload("errore item not found "+ex.getMessage());
//    }
//
//}
