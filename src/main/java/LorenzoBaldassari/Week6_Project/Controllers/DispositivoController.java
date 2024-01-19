package LorenzoBaldassari.Week6_Project.Controllers;

import LorenzoBaldassari.Week6_Project.Entities.Dispositivo;
import LorenzoBaldassari.Week6_Project.Entities.Utente;
import LorenzoBaldassari.Week6_Project.Exceptions.BadRequestException;
import LorenzoBaldassari.Week6_Project.Payloads.Dispositivo.RequestDispositivoDtoClass;
import LorenzoBaldassari.Week6_Project.Payloads.Dispositivo.RequestDisposivoDto;
import LorenzoBaldassari.Week6_Project.Payloads.Dispositivo.RespondDispsitivoDto;
import LorenzoBaldassari.Week6_Project.Payloads.Utente.RequestUtenteDto;
import LorenzoBaldassari.Week6_Project.Payloads.Utente.RespondUtenteDto;
import LorenzoBaldassari.Week6_Project.Services.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/dispositivi")
public class DispositivoController {

    @Autowired
    private DispositivoService dispositivoService;

    @GetMapping
    public List<Dispositivo> getDispositiviList() {
        return dispositivoService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RespondDispsitivoDto postDispositivo(@RequestBody @Validated RequestDispositivoDtoClass body,
                                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.err.println(bindingResult.getAllErrors());
            throw new BadRequestException("errore nel invio del payload per il metodo POST"+bindingResult.getAllErrors());
        } else {
            return dispositivoService.PostDispositivo(body);
        }
    }
    @GetMapping("/{id}")
    public Dispositivo findById(@PathVariable UUID id) {
        return dispositivoService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        dispositivoService.delete(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public RespondDispsitivoDto modify(@RequestBody @Validated RequestDispositivoDtoClass body,
                                   @PathVariable UUID id, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            System.err.println(bindingResult.getAllErrors());
            throw new BadRequestException("errore nel invio del payload per il metodo POST"+bindingResult.getAllErrors());
        } else {
            return dispositivoService.findByIdAndModify(body,id);
        }
    }
}
