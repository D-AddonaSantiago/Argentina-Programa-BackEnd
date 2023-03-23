package com.portfolio.sd.Controller;

import com.portfolio.sd.Entity.Educacion;
import com.portfolio.sd.Interface.IEducacionService;
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
public class EducacionController {
    @Autowired IEducacionService ieducacionService;
    
    @GetMapping("educacion/traer")
    public List<Educacion> getEducacion() {
        return ieducacionService.getEducacion();
    }
    
    @PostMapping("/educacion/crear")
    public void createEducacion(@RequestBody Educacion educacion) {
        ieducacionService.saveEducacion(educacion);
    }
    
    @DeleteMapping("/educacion/borrar/{id}")
    public void deleteEducacion(@PathVariable Long id) {
        ieducacionService.deleteEducacion(id);
    }         
    
    @PutMapping("/educacion/editar/{id}")
    public void editEducacion(@PathVariable Long id,
                              @RequestParam("titulo") String nuevoTitulo,
                              @RequestParam("descripcion") String nuevoDescripcion,
                              @RequestParam("img") String nuevoImg) {
        Educacion educacion = ieducacionService.findEducacion(id);
        educacion.setTitulo(nuevoTitulo);
        educacion.setDescripcion(nuevoDescripcion);
        educacion.setImg(nuevoImg);
        
        ieducacionService.saveEducacion(educacion);
    }
    
    @GetMapping("/educacion/traer/edu")
    public Educacion findEducacion() {
        return ieducacionService.findEducacion((long)1);
    }
    
}
