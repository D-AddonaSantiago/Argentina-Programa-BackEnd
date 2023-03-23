package com.portfolio.sd.Controller;

import com.portfolio.sd.Entity.Proyecto;
import com.portfolio.sd.Interface.IProyectoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
public class ProyectoController {
    @Autowired IProyectoService iproyectoService;
    
    @GetMapping("proyecto/traer")
    public List<Proyecto> getProyecto() {
        return iproyectoService.getProyecto();
    }
    
    @PostMapping("/proyecto/crear")
    public void createProyecto(@RequestBody Proyecto proyecto) {
        iproyectoService.saveProyecto(proyecto);
    }
    
    @DeleteMapping("/proyecto/borrar/{id}")
    public void deleteProyecto(@PathVariable Long id) {
        iproyectoService.deleteProyecto(id);
    }
    
    @PutMapping("/proyecto/editar/{id}")
    public void editProyecto(@PathVariable Long id,
                             @RequestParam("titulo") String nuevoTitulo,
                             @RequestParam("descripcion") String nuevoDescripcion,
                             @RequestParam("img") String nuevoImg,
                             @RequestParam("img2") String nuevoImg2,
                             @RequestParam("img3") String nuevoImg3) {
        Proyecto proyecto = iproyectoService.findProyecto(id);
        proyecto.setTitulo(nuevoTitulo);
        proyecto.setDescripcion(nuevoDescripcion);
        proyecto.setImg(nuevoImg);
        proyecto.setImg2(nuevoImg2);
        proyecto.setImg3(nuevoImg3);
        
        iproyectoService.saveProyecto(proyecto);
    }
    
    @GetMapping("/proyecto/traer/proy")
    public Proyecto findProyecto() {
        return iproyectoService.findProyecto((long)1);
    }
    
}
