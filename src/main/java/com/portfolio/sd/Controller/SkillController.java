package com.portfolio.sd.Controller;

import com.portfolio.sd.Entity.Skill;
import com.portfolio.sd.Interface.ISkillService;
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
public class SkillController {
    @Autowired ISkillService iskillService;
    
    @GetMapping("skill/traer")
    public List<Skill> getSkill() {
        return iskillService.getSkill();
    }
    
    @PostMapping("/skill/crear")
    public void createSkill(@RequestBody Skill skill) {
        iskillService.saveSkill(skill);
    }
    
    @DeleteMapping("/skill/borrar/{id}")
    public void deleteSkill(@PathVariable Long id) {
        iskillService.deleteSkill(id);
    }
    
    @PutMapping("/skill/editar/{id}")
    public void editSkill(@PathVariable Long id,
                          @RequestParam("nombre") String nuevoNombre,
                          @RequestParam("valor") Integer nuevoValor) {
        Skill skill = iskillService.findSkill(id);
        skill.setNombre(nuevoNombre);
        skill.setValor(nuevoValor);
        
        iskillService.saveSkill(skill);
    }
    
}
