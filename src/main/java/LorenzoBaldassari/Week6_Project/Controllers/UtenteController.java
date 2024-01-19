package LorenzoBaldassari.Week6_Project.Controllers;

import LorenzoBaldassari.Week6_Project.Entities.Utente;
import LorenzoBaldassari.Week6_Project.Exceptions.BadRequestException;
import LorenzoBaldassari.Week6_Project.Payloads.Utente.RequestUtenteDto;
import LorenzoBaldassari.Week6_Project.Payloads.Utente.RespondUtenteDto;
import LorenzoBaldassari.Week6_Project.Services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/utenti")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    @GetMapping
    public List<Utente> getAutoriList() {
        return utenteService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RespondUtenteDto postUtente(@RequestBody @Validated RequestUtenteDto body,
                                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.err.println(bindingResult.getAllErrors());
            throw new BadRequestException("errore nel invio del payload per il metodo POST");
        } else {
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
            throw new BadRequestException("errore nel invio del payload per il metodo POST");
        } else {
        return utenteService.findByIdAndModify(id,body);
        }
    }
}
