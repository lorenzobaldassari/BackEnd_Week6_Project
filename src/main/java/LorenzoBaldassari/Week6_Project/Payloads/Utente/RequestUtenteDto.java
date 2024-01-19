package LorenzoBaldassari.Week6_Project.Payloads.Utente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record RequestUtenteDto(
        @Size(min=3, max=10,message="nome  troppo corto")
        @Size(max=15, message="nome  troppo lungo")
        String username,
        @Size(min=3, max=10,message="nome  troppo corto")
        @Size(max=15, message="nome  troppo lungo")
        String nome,
        @Size(min=3, max=10,message="nome  troppo corto")
        @Size(max=15, message="nome  troppo lungo")
        String cognome,
        @Email
        String email
) {
}
