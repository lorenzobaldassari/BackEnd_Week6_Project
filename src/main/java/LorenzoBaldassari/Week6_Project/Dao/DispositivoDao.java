package LorenzoBaldassari.Week6_Project.Dao;

import LorenzoBaldassari.Week6_Project.Entities.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DispositivoDao extends JpaRepository<Dispositivo, UUID> {
}
