package ma.yc.api.services;

import ma.yc.api.dto.PromotionCentreRequestDto;
import ma.yc.api.dto.PromotionDto;
import ma.yc.api.dto.PromotionStatistique;

import java.util.Collection;

public interface PromotiomAuNiveauCentreService {
    Collection<PromotionDto> ListPromotion(PromotionCentreRequestDto promotionCentreRequestDto);
    Collection<PromotionStatistique> StatisticPromotionCentre(PromotionCentreRequestDto promotionCentreRequestDto);
}
