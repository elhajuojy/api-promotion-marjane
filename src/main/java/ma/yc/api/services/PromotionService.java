package ma.yc.api.services;

import ma.yc.api.dto.ProduitDto;
import ma.yc.api.dto.PromotionDto;

import java.util.List;

public interface PromotionService {
    public ProduitDto addPromotion(ProduitDto produitDto, PromotionDto promotionDto);
    public List<PromotionDto> getAll();
}
