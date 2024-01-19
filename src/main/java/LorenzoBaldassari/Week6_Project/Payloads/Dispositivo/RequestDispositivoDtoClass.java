package LorenzoBaldassari.Week6_Project.Payloads.Dispositivo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.UUID;

@Getter
public class RequestDispositivoDtoClass {
    @Size(min=3,message="tipologia dispositvo nome  troppo corto")
    @Size(max=20, message="tipologia dispositvo nome  troppo lungo")
    @NotNull(message="il campo non deve essere null")
    private String tipologiadispositivo;
    @Size(min=3,message="stato dispositivo nome  troppo corto")
    @Size(max=20,message="stato dispositivo nome  troppo lungo")
    @NotNull(message="il campo non deve essere null")
    private String statoDispositivo;

    private UUID uuidUtente;

    public RequestDispositivoDtoClass(String tipologiadispositivo, String statoDispositivo, UUID uuidUtente) {
        this.tipologiadispositivo = tipologiadispositivo;
        this.statoDispositivo = statoDispositivo;
        this.uuidUtente = uuidUtente;
    }

    public RequestDispositivoDtoClass(String tipologiadispositivo, String statoDispositivo) {
        this.tipologiadispositivo = tipologiadispositivo;
        this.statoDispositivo = statoDispositivo;
    }

    public RequestDispositivoDtoClass() {
    }
}
