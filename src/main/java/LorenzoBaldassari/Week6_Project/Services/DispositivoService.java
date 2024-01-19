package LorenzoBaldassari.Week6_Project.Services;

import LorenzoBaldassari.Week6_Project.Controllers.DispositivoController;
import LorenzoBaldassari.Week6_Project.Dao.DispositivoDao;
import LorenzoBaldassari.Week6_Project.Entities.Dispositivo;
import LorenzoBaldassari.Week6_Project.Entities.Utente;
import LorenzoBaldassari.Week6_Project.Exceptions.ItemNotFoundException;
import LorenzoBaldassari.Week6_Project.Payloads.Dispositivo.RequestDispositivoDtoClass;
import LorenzoBaldassari.Week6_Project.Payloads.Dispositivo.RequestDisposivoDto;
import LorenzoBaldassari.Week6_Project.Payloads.Dispositivo.RespondDispsitivoDto;
import LorenzoBaldassari.Week6_Project.Payloads.Utente.RequestUtenteDto;
import LorenzoBaldassari.Week6_Project.Payloads.Utente.RespondUtenteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DispositivoService {


    @Autowired
    private DispositivoDao dispositivoDao;
    @Autowired
    private UtenteService utenteService;

    public List<Dispositivo> findAll(){
        return dispositivoDao.findAll();
    }

    public RespondDispsitivoDto PostDispositivo(RequestDispositivoDtoClass body){
        Dispositivo dispositivo = new Dispositivo();
        if(body.getUuidUtente()!= null)
        {
        Utente utente= utenteService.findById(body.getUuidUtente());
        dispositivo.setUtente(utente);
        }
        dispositivo.setStatoDispositivo(body.getStatoDispositivo());
        dispositivo.setTipologiadispositivo(body.getTipologiadispositivo());
        dispositivoDao.save(dispositivo);
        return new RespondDispsitivoDto(dispositivo.getId());
    }

    public Dispositivo findById(UUID id){
        return dispositivoDao.findById(id).orElseThrow(()->new ItemNotFoundException(id));
    }

    public void delete(UUID id){
        dispositivoDao.delete(this.findById(id));
    }

    public RespondDispsitivoDto findByIdAndModify(RequestDispositivoDtoClass body, UUID idDispositivo){
        Dispositivo dispositivo = this.findById(idDispositivo);
        if(body.getUuidUtente()!= null)
        {
            Utente utente= utenteService.findById(body.getUuidUtente());
            dispositivo.setUtente(utente);
        }else{dispositivo.setUtente(null);}
        dispositivo.setStatoDispositivo(body.getStatoDispositivo());
        dispositivo.setTipologiadispositivo(body.getTipologiadispositivo());
        dispositivoDao.save(dispositivo);
        return new RespondDispsitivoDto(dispositivo.getId());
    }


}
