
package com.portfolio.sd.Repository;

import com.portfolio.sd.Entity.LinksNav;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILinksNavRepository extends JpaRepository<LinksNav,Long>{
    
}
