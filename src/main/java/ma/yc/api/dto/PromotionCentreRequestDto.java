package ma.yc.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.yc.api.enums.StatusPromotion;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PromotionCentreRequestDto {
    private StatusPromotion status;
    private Long centre_id;
    private PromotionDto promotion;

}
