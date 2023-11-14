package ma.yc.api.services;

import ma.yc.api.dto.ResponsablePromotionRequest;
import ma.yc.api.dto.ResponsablePromotionResponse;

public interface ResponsablePromotionService {

    public ResponsablePromotionResponse ApprouverOuRefuserPromotion(ResponsablePromotionRequest responsablePromotionRequest);

}
