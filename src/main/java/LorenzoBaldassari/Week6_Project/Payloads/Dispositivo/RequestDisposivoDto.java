package LorenzoBaldassari.Week6_Project.Payloads.Dispositivo;

import LorenzoBaldassari.Week6_Project.Entities.Enum.StatoDispositivo;
import LorenzoBaldassari.Week6_Project.Entities.Enum.Tipologiadispositivo;

public record RequestDisposivoDto(
        Tipologiadispositivo tipologiadispositivo,
        StatoDispositivo statoDispositivo
) {
}
