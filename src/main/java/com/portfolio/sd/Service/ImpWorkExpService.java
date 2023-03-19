package com.portfolio.sd.Service;

import com.portfolio.sd.Entity.WorkExp;
import com.portfolio.sd.Interface.IWorkExpService;
import com.portfolio.sd.Repository.IWorkExpRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpWorkExpService implements IWorkExpService{
    @Autowired IWorkExpRepository iworkExpRepository;
    
    @Override
    public List<WorkExp> getWorkExp() {
        List<WorkExp> workExp = iworkExpRepository.findAll();
        return workExp;
    }
    
    @Override
    public void saveWorkExp(WorkExp workExp) {
        iworkExpRepository.save(workExp);
    }
    
    @Override
    public void deleteWorkExp(Long id) {
        iworkExpRepository.deleteById(id);
    }
    
    @Override
    public WorkExp findWorkExp(Long id) {
        WorkExp workExp = iworkExpRepository.findById(id).orElse(null);
        return workExp;
    }    
}
