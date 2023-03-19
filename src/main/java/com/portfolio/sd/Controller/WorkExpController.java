
package com.portfolio.sd.Controller;

import com.portfolio.sd.Entity.WorkExp;
import com.portfolio.sd.Interface.IWorkExpService;
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
@CrossOrigin(origins = "http://localhost:4200")
public class WorkExpController {
    @Autowired IWorkExpService iworkExpService;
    
    @GetMapping("work_exp/traer")
    public List<WorkExp> getWorkExp() {
        return iworkExpService.getWorkExp();
    }
    
    @PostMapping("/work_exp/crear")
    public void createWorkExp(@RequestBody WorkExp workExp) {
        iworkExpService.saveWorkExp(workExp);
    }
    
    @DeleteMapping("/work_exp/borrar/{id}")
    public void deleteWorkExp(@PathVariable Long id) {
        iworkExpService.deleteWorkExp(id);
    }
    
    @PutMapping("/work_exp/editar/{id}")
    public void editWorkExp(@PathVariable Long id,
                               @RequestParam("titulo") String nuevoTitulo,
                               @RequestParam("descripcion") String nuevoDescripcion,
                               @RequestParam("img") String nuevoImg) {
        WorkExp workExp = iworkExpService.findWorkExp(id);
        workExp.setTitulo(nuevoTitulo);
        workExp.setDescripcion(nuevoDescripcion);
        workExp.setImg(nuevoImg);
        
        iworkExpService.saveWorkExp(workExp);
    }
    
    @GetMapping("/work_exp/traer/trabajo")
    public WorkExp findWorkExp() {
        return iworkExpService.findWorkExp((long)1);
    }
    
}
