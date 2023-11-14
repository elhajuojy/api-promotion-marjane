package ma.yc.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.yc.api.enums.StatusPromotion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PromotionStatistique {

    private StatusPromotion status ;
    private Date date_applique;
    private Collection<ProuitStatisticDto> produits = new ArrayList<>();
}
