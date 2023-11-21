package ma.yc.api.repository;

import ma.yc.api.entity.AdminGeneral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminGeneralAuthentificationRespository extends JpaRepository<AdminGeneral, Long> {
    public AdminGeneral findByEmail(String email);
    

}
