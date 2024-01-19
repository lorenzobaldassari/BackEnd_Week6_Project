package LorenzoBaldassari.Week6_Project.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "utenti")
@Getter
@Setter
public class Utente {

    @Id
    @GeneratedValue
    private UUID id;
    private String username;
    private String nome;
    private String cognome;
    private String email;
    private String urlImmagineDiProfilo;

    @JsonIgnore
    @OneToMany(mappedBy = "utente")
    private List<Dispositivo> listaDiDispositivi;


    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
