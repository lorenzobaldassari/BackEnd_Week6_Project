package LorenzoBaldassari.Week6_Project.Exceptions;

import lombok.Getter;
import org.springframework.validation.ObjectError;

import java.util.List;

@Getter
public class BadRequestException extends RuntimeException{
    private List<ObjectError> objectErrorlist;

    public BadRequestException(String message){super(message);
    }

    public BadRequestException(String message, List<ObjectError> list){

        super("errore nel payload");
        this.objectErrorlist=list;
    }

}
