
package com.portfolio.sd.Controller;

import com.portfolio.sd.Entity.LinksNav;
import com.portfolio.sd.Interface.ILinksNavService;
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
public class LinksNavController {
    @Autowired ILinksNavService ilinksNavService;
    
    @GetMapping("linksNav/traer")
    public List<LinksNav> getLinksNav() {
        return ilinksNavService.getLinksNav();
    }
    
    @PostMapping("/linksNav/crear")
    public void createLinksNav(@RequestBody LinksNav linksNav) {
        ilinksNavService. saveLinksNav(linksNav);
    }
    
    @DeleteMapping("/linksNav/borrar/{id}")
    public void deleteLinksNav(@PathVariable Long id){
        ilinksNavService.deleteLinksNav(id);
    }
    
    @PutMapping("/linksNav/editar/{id}")
    public void editLinksNav(@PathVariable Long id,
                                 @RequestParam("title") String nuevoTitle,
                                 @RequestParam("url") String nuevoUrl) {
        LinksNav linksNav = ilinksNavService.findLinksNav(id);
        linksNav.setTitle(nuevoTitle);
        linksNav.setUrl(nuevoUrl);
        
        ilinksNavService.saveLinksNav(linksNav);    
    }
    
    @GetMapping("/linksNav/traer/link")
    public LinksNav findLinksNav(){
        return ilinksNavService.findLinksNav((long)1);
    }
    
}
