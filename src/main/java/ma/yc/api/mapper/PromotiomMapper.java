package ma.yc.api.mapper;

import ma.yc.api.dto.PromotionDto;
import ma.yc.api.entity.Promotion;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PromotiomMapper {
    PromotiomMapper promotionMapper = Mappers.getMapper(PromotiomMapper.class);

    Promotion toEntity(PromotionDto promotionDto);

    PromotionDto toDto(Promotion promotion);
}
