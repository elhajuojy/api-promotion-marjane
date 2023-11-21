package ma.yc.api.mappers;

import ma.yc.api.dto.PromotionStatistique;
import ma.yc.api.entity.Promotion;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface StatisticPromotionMapper {
    StatisticPromotionMapper statisticPromotionMapper = Mappers.getMapper(StatisticPromotionMapper.class);

    Promotion toEntity(PromotionStatistique promotionStatistique);

    PromotionStatistique toDto(Promotion promotion);
}
