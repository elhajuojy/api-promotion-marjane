package ma.yc.api.repository;

import ma.yc.api.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

public interface PromotionAuNiveauCentreRepository extends JpaRepository<Promotion, Long> {
    Optional<Collection<Promotion>> findAllByCentre_idAndStatus(Long id, String status);
    Optional<Collection<Promotion>> findAllByCentre_id(Long id);

}
