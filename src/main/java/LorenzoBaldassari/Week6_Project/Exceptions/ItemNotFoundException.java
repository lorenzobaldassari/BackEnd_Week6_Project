package LorenzoBaldassari.Week6_Project.Exceptions;

import java.util.UUID;

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(UUID id){
        super("elemento " +id+ " non trovato");
    }
}
