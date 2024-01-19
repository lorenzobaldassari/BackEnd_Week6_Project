package LorenzoBaldassari.Week6_Project;

import LorenzoBaldassari.Week6_Project.Dao.DispositivoDao;
import LorenzoBaldassari.Week6_Project.Entities.Enum.StatoDispositivo;
import LorenzoBaldassari.Week6_Project.Entities.Enum.Tipologiadispositivo;
import LorenzoBaldassari.Week6_Project.Payloads.Dispositivo.RequestDisposivoDto;
import LorenzoBaldassari.Week6_Project.Services.DispositivoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class Week6ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(Week6ProjectApplication.class, args);
	}



}
