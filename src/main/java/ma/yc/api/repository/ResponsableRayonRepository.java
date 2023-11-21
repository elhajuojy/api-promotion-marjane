package ma.yc.api.repository;

import ma.yc.api.entity.ResponsableRayon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ResponsableRayonRepository extends JpaRepository<ResponsableRayon,Long>{
    public ResponsableRayon findByEmail(String email);
}
