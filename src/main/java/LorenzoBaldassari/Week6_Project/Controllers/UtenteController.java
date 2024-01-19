package LorenzoBaldassari.Week6_Project.Controllers;

import LorenzoBaldassari.Week6_Project.Dao.UtenteDao;
import LorenzoBaldassari.Week6_Project.Entities.Utente;
import LorenzoBaldassari.Week6_Project.Exceptions.BadRequestException;
import LorenzoBaldassari.Week6_Project.Payloads.Utente.RequestUtenteDto;
import LorenzoBaldassari.Week6_Project.Payloads.Utente.RespondUtenteDto;
import LorenzoBaldassari.Week6_Project.Services.UtenteService;
import LorenzoBaldassari.Week6_Project.config.MailgunSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/utenti")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;
    @Autowired
    private UtenteDao utenteDao;

    @GetMapping
    public List<Utente> getAutoriList() {
        return utenteService.findAll();
    }

    @Autowired
    private MailgunSender mailgunSender;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RespondUtenteDto postUtente(@RequestBody @Validated RequestUtenteDto body,
                                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.err.println(bindingResult.getAllErrors());
            throw new BadRequestException("errore nel invio del payload per il metodo POST"+bindingResult.getAllErrors());
        } else {
            mailgunSender.sendRegistrationEmail("lorenzobaldassari93@gmail.com");
//            mailgunSender.sendRegistrationEmail(body.email());
            return utenteService.PostUtente(body);
        }
    }

    @GetMapping("/{id}")
    public Utente findById(@PathVariable UUID id) {
        return utenteService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        utenteService.delete(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public RespondUtenteDto modify(@RequestBody @Validated RequestUtenteDto body,
                                   @PathVariable UUID id, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            System.err.println(bindingResult.getAllErrors());
            throw new BadRequestException("errore nel invio del payload per il metodo POST"+bindingResult.getAllErrors());
        } else {
        return utenteService.findByIdAndModify(id,body);
        }
    }
    @PostMapping("/{id}/upload")
    public String uploadAvatar(@RequestParam("avatar") MultipartFile file, @PathVariable UUID id) throws IOException {
           String  url =utenteService.uploadPicture(file);
           Utente utente = utenteService.findById(id);
           utente.setUsername(utente.getUsername());
           utente.setNome(utente.getNome());
           utente.setCognome(utente.getCognome());
           utente.setEmail(utente.getEmail());
           utente.setUrlImmagineDiProfilo(url);
           utenteDao.save(utente);
     return "ok immagine salvata su"+url;

    }

}
