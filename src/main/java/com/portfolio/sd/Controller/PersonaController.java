package com.portfolio.sd.Controller;

import com.portfolio.sd.Entity.Persona;
import com.portfolio.sd.Service.ImpPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"https://sdfrontend.web.app", "http://localhost:4200"})
public class PersonaController {

    @Autowired
    ImpPersonaService ipersonaService;

    @GetMapping("/personas/traer")
    public List<Persona> getPersona() {
        return ipersonaService.getPersona();
    }

    @PostMapping("/personas/crear")
    public void createPersona(@RequestBody Persona persona) {
        ipersonaService.savePersona(persona);
    }

    @DeleteMapping("/personas/borrar/{id}")
    public void deletePersona(@PathVariable Long id) {
        ipersonaService.deletePersona(id);
    }

    @PutMapping("/personas/editar/{id}")
    public void editPersona(@PathVariable Long id, @RequestBody Persona updatedPersona) {
        Persona personaExistente = ipersonaService.findPersona(id);

        if (personaExistente != null) {
            personaExistente.setNombre(updatedPersona.getNombre());
            personaExistente.setApellido(updatedPersona.getApellido());
            personaExistente.setAbout_me(updatedPersona.getAbout_me());
            personaExistente.setImg(updatedPersona.getImg());

            ipersonaService.savePersona(personaExistente);
        } else {
            System.out.println("Persona not found with id: " + id);
        }
    }

    @GetMapping("/personas/traer/perfil")
    public Persona findPersona() {
        return ipersonaService.findPersona((long) 1);
    }

}
