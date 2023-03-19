package com.portfolio.sd.Interface;

import com.portfolio.sd.Entity.Educacion;
import java.util.List;


public interface IEducacionService {
    //Traer una lista de Educaciones
    public List<Educacion> getEducacion();
    
    //Guardar un objeto de tipo Educacion
    public void saveEducacion(Educacion educacion);
    
    //Eliminar un objeto por ID
    public void deleteEducacion(Long id);
    
    //Buscar Educacion por ID
    public Educacion findEducacion(Long id);
}
