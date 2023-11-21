package ma.yc.api.repository;

import ma.yc.api.entity.Promotion;
import ma.yc.api.enums.StatusPromotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;


public interface StatisticsPromotionsAuNiveauDuRoyaumeRepository extends JpaRepository<Promotion ,Long> {

    public Optional<Collection<Promotion>> findAllByStatus(StatusPromotion statusPromotion);
}
