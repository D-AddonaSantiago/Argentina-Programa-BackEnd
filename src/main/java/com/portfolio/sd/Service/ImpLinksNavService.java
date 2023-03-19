
package com.portfolio.sd.Service;

import com.portfolio.sd.Entity.LinksNav;
import com.portfolio.sd.Interface.ILinksNavService;
import com.portfolio.sd.Repository.ILinksNavRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ImpLinksNavService  implements ILinksNavService{
    @Autowired ILinksNavRepository ilinksNavRepository;
    
    @Override
    public List<LinksNav> getLinksNav() {
        List<LinksNav> linksNav = ilinksNavRepository.findAll();
        return linksNav;
    }
    
    @Override
    public void saveLinksNav(LinksNav linksNav) {
        ilinksNavRepository.save(linksNav);
    }
    
    @Override
    public void deleteLinksNav(Long id) {
        ilinksNavRepository.deleteById(id);
    }
    
    @Override
    public LinksNav findLinksNav(Long id) {
        LinksNav linksNav = ilinksNavRepository.findById(id).orElse(null);
        return linksNav;
    }
}
