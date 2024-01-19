package LorenzoBaldassari.Week6_Project.Payloads.Utente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RequestUtenteDto(
        @Size(min=3,message="username  troppo corto")
        @Size(max=15, message="username  troppo lungo")
        @NotNull(message="il campo non deve essere null")
        String username,
        @Size(min=3,message="nome  troppo corto")
        @Size(max=15, message="nome  troppo lungo")
        @NotNull(message="il campo non deve essere null")
        String nome,
        @Size(min=3,message="cognome  troppo corto")
        @Size(max=15, message="cognome  troppo lungo")
        @NotNull(message="il campo non deve essere null")
        String cognome,
        @Email
        @NotNull(message="il campo non deve essere null")
        String email
) {
}
