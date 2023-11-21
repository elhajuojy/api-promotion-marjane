package ma.yc.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.yc.api.enums.StatusPromotion;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponsablePromotionDto {
    private Long id ;
    private StatusPromotion status ;
}
