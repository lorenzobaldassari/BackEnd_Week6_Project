package LorenzoBaldassari.Week6_Project.Services;

import LorenzoBaldassari.Week6_Project.Dao.UtenteDao;
import LorenzoBaldassari.Week6_Project.Entities.Utente;
import LorenzoBaldassari.Week6_Project.Exceptions.ItemNotFoundException;
import LorenzoBaldassari.Week6_Project.Payloads.Utente.RequestUtenteDto;
import LorenzoBaldassari.Week6_Project.Payloads.Utente.RespondUtenteDto;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class UtenteService {

    @Autowired
    private UtenteDao utenteDao;
    @Autowired
    private Cloudinary cloudinaryUploader;

    public List<Utente> findAll(){
        return utenteDao.findAll();
    }

    public RespondUtenteDto PostUtente(RequestUtenteDto body){
        Utente utente = new Utente();
        utente.setUrlImmagineDiProfilo("https://ui-avatars.com/api/?name=" + body.nome() + "+" + body.cognome());
        utente.setUsername(body.username());
        utente.setNome(body.nome());
        utente.setCognome(body.cognome());
        utente.setEmail(body.email());
        utenteDao.save(utente);
        return new RespondUtenteDto(utente.getId(), utente.getUsername());
    }
    public Utente findById(UUID id){
        return utenteDao.findById(id).orElseThrow(()->new ItemNotFoundException(id));
    }

    public void delete(UUID id){
        Utente utene=utenteDao.findById(id).orElseThrow(()->new ItemNotFoundException(id));
        utenteDao.delete(utene);
    }

    public RespondUtenteDto findByIdAndModify(UUID id, RequestUtenteDto body){
        Utente utente = this.findById(id);
        utente.setUrlImmagineDiProfilo("https://ui-avatars.com/api/?name=" + body.nome() + "+" + body.cognome());
        utente.setUsername(body.username());
        utente.setNome(body.nome());
        utente.setCognome(body.cognome());
        utente.setEmail(body.email());
        utenteDao.save(utente);
        return new RespondUtenteDto(utente.getId(), utente.getUsername());
    }
    public String uploadPicture(MultipartFile file) throws IOException {
        String url= (String) cloudinaryUploader.uploader()
                .upload(file.getBytes(), ObjectUtils.emptyMap())
                .get("url");
        return url;
    }

}
