package ma.yc.api.services;

import ma.yc.api.dto.PromotionCentreRequestDto;

public interface PromotionCentreService {
    public PromotionCentreRequestDto addPromotion(PromotionCentreRequestDto promotionCentreRequestDto);

    void deletePromotion(Long id);

    void updatePromotion(PromotionCentreRequestDto promotionCentreRequestDto);
}
