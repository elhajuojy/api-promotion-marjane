package ma.yc.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.yc.api.enums.StatusPromotion;

import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PromotionStatistiques {
    private int size ;
    private StatusPromotion status;
    private Collection<PromotionStatistique> promoitons = new ArrayList<>();
}
