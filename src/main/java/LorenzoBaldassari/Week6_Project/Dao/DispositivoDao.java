package LorenzoBaldassari.Week6_Project.Dao;

import LorenzoBaldassari.Week6_Project.Entities.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DispositivoDao extends JpaRepository<Dispositivo, UUID> {
}
