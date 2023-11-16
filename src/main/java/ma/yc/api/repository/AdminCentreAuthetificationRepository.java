package ma.yc.api.repository;

import ma.yc.api.entity.AdminCentre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminCentreAuthetificationRepository extends JpaRepository<AdminCentre, Long> {
    public AdminCentre findByEmail(String email);
}
