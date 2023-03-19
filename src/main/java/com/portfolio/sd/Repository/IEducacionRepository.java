package com.portfolio.sd.Repository;

import com.portfolio.sd.Entity.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IEducacionRepository extends JpaRepository<Educacion, Long>{
    
}
