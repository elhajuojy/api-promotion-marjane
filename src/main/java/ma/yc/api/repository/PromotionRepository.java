package ma.yc.api.repository;

import ma.yc.api.entity.Promotion;
import ma.yc.api.enums.StatusPromotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public interface PromotionRepository extends JpaRepository<Promotion,Long> {
    public Promotion findByDescription(String description);
    public Collection<Promotion> findAllByStatus(StatusPromotion status);



}
