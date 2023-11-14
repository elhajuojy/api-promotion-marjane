package ma.yc.api.services;

import ma.yc.api.dto.PromotionStatistiques;

import java.util.Collection;

public interface StatisticsPromotionsAuNiveauDuRoyaumeService {

    public Collection<PromotionStatistiques> getStatisticsPromotionsAuNiveauDuRoyaume(String...status);
}
