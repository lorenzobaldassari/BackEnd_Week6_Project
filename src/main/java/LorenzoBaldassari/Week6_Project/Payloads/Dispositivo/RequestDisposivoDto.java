package LorenzoBaldassari.Week6_Project.Payloads.Dispositivo;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record RequestDisposivoDto(
        @Size(min=3,message="tipologia dispositvo nome  troppo corto")
        @Size(max=20, message="tipologia dispositvo nome  troppo lungo")
        @NotNull(message="il campo non deve essere null")
        String tipologiadispositivo,
        @Size(min=3,message="stato dispositivo nome  troppo corto")
        @Size(max=20,message="stato dispositivo nome  troppo lungo")
        @NotNull(message="il campo non deve essere null")
        String statoDispositivo,

        UUID uuidUtente
) {
}
