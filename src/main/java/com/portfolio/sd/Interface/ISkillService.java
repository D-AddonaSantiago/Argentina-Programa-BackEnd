package com.portfolio.sd.Interface;

import com.portfolio.sd.Entity.Skill;
import java.util.List;

public interface ISkillService {

    public List<Skill> getSkill();
    
    public void saveSkill(Skill skill);
    
    public void deleteSkill(Long id);
    
    public Skill findSkill(Long id);
    
}
