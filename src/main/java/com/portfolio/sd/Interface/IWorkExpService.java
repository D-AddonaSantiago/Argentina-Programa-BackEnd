package com.portfolio.sd.Interface;

import com.portfolio.sd.Entity.WorkExp;
import java.util.List;


public interface IWorkExpService {

    public List<WorkExp> getWorkExp();
    
    public void saveWorkExp(WorkExp workExp);
    
    public void deleteWorkExp(Long id);
    
    public WorkExp findWorkExp(Long id);
    
}
