package LorenzoBaldassari.Week6_Project.Payloads.Utente;

import java.util.UUID;

public record RespondUtenteDto(
        UUID id,
        String username
) {
}
