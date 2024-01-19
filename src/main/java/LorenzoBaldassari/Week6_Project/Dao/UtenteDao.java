package LorenzoBaldassari.Week6_Project.Dao;

import LorenzoBaldassari.Week6_Project.Entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UtenteDao extends JpaRepository<Utente,UUID> {
}
