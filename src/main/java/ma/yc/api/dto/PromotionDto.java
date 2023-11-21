package ma.yc.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.yc.api.entity.Produit;
import ma.yc.api.enums.StatusPromotion;

import java.util.Collection;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PromotionDto {
    private Date createdAt;
    private Date updatedAt;
    private Double precentage;
    private String description;
    private StatusPromotion status;
    private Date dateDebut;
    private Date dateFin;
    @Schema(description = "la list des promotions concrene par cette promotion")
    private Collection<Produit> produits;
}
