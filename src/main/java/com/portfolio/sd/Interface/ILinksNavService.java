
package com.portfolio.sd.Interface;

import com.portfolio.sd.Entity.LinksNav;
import java.util.List;


public interface ILinksNavService {
    //Traer la lista de links
    public List<LinksNav> getLinksNav();
    
    //Guardar un link
    public void saveLinksNav(LinksNav linksNav);
    
    //Eliminar un link por id
    public void deleteLinksNav(Long id);
    
    //Buscar link por ID
    public LinksNav findLinksNav(Long id);
}
