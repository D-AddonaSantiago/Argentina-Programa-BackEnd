package com.portfolio.sd.Interface;

import com.portfolio.sd.Entity.Proyecto;
import java.util.List;


public interface IProyectoService {
    
    public List<Proyecto> getProyecto();
    
    public void saveProyecto(Proyecto proyecto);
    
    public void deleteProyecto(Long id);
    
    public Proyecto findProyecto(Long id);
    
}
