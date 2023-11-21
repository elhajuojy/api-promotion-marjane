package ma.yc.api.mapper;

import ma.yc.api.dto.ProduitDto;
import ma.yc.api.dto.PromotionDto;
import ma.yc.api.entity.Produit;
import ma.yc.api.entity.Promotion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

public interface PromotiomMapper {
    PromotiomMapper INSTANCE = Mappers.getMapper(PromotiomMapper.class);

    Promotion toEntity(PromotionDto promotionDto);

    @Mappings({
            @Mapping(target = "updatedAt", source = "promotion.updatedAt"),
            @Mapping(target = "dateFin", source = "promotion.dateFin"),
            @Mapping(target = "status", source = "promotion.status"),
            @Mapping(target = "produits", source = "promotion.produits"),
    })
    PromotionDto toDto(Promotion promotion);

    default ProduitDto produitToProduitDto(Produit produit){
        return Mappers.getMapper(ProduitMapper.class).toDto(produit);
    }

}
