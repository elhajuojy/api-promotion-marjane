package ma.yc.api.repository;

import ma.yc.api.entity.Responsable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsableAuthRepository extends JpaRepository<Responsable,Long>{
    public Responsable findByEmail(String email);
}
