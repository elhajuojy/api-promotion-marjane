package ma.yc.api.mapper;

import ma.yc.api.dto.PromotionStatistique;
import ma.yc.api.entity.Promotion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PromotionStatistiqueMapper
{

    PromotionStatistiqueMapper promotionMapper = Mappers.getMapper(PromotionStatistiqueMapper.class);

//    @Mapping(target = "Promotion.update", source = "promotionStatistique.date_applique")
    Promotion toEntity(PromotionStatistique promotionStatistique);

//    @Mapping(target = "PromotionStatistique.date_applique", source = "promotion.updatedAt")
    PromotionStatistique toDto(Promotion promotion);
}
