package LorenzoBaldassari.Week6_Project.Entities;

import LorenzoBaldassari.Week6_Project.Entities.Enum.StatoDispositivo;
import LorenzoBaldassari.Week6_Project.Entities.Enum.Tipologiadispositivo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "dispositivi")
@Getter
@Setter
@ToString
public class Dispositivo {

    @Id
    @GeneratedValue
    private UUID id;

    private String tipologiadispositivo;

    private String statoDispositivo;

    @ManyToOne
    @JoinColumn(name = "id_utente")
    private Utente utente;

}
