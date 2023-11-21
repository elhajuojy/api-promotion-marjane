package ma.yc.api.mapper;

import ma.yc.api.dto.ResponsablePromotionDto;
import ma.yc.api.entity.Promotion;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ResponsablePromotoinMapper {
    ResponsablePromotoinMapper INSTANCE = Mappers.getMapper(ResponsablePromotoinMapper.class);

    Promotion toEntity(ResponsablePromotionDto responsablePromotionDto);

    ResponsablePromotionDto toDto(Promotion promotion);
}
