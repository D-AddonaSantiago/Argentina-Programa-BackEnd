package com.portfolio.sd.Repository;

import com.portfolio.sd.Entity.WorkExp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IWorkExpRepository extends JpaRepository<WorkExp,Long>{
    
}
