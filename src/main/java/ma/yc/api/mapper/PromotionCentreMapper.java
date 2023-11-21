package ma.yc.api.mapper;

import ma.yc.api.dto.PromotionCentreRequestDto;
import ma.yc.api.dto.PromotionDto;
import ma.yc.api.entity.Promotion;
import org.mapstruct.Mapper;

@Mapper
public interface PromotionCentreMapper {
    PromotionCentreMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(PromotionCentreMapper.class);



    PromotionCentreRequestDto toDto(Promotion promotion);
    Promotion toEntity(PromotionCentreRequestDto promotionCentreRequestDto);

    default PromotionDto promotionToPromotionDto(Promotion promotion){
        return org.mapstruct.factory.Mappers.getMapper(PromotionMapper.class).toDto(promotion);
    }
}
