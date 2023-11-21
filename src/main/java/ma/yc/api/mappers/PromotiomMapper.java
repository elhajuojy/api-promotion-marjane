package ma.yc.api.mappers;


import ma.yc.api.dto.PromotionDto;
import ma.yc.api.entity.Promotion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PromotiomMapper {
    PromotiomMapper INSTANCE = Mappers.getMapper(PromotiomMapper.class);

    Promotion toEntity(PromotionDto promotionDto);

    @Mappings({
            @Mapping(target = "dateDebut", source = "promotion.dateDebut"),
            @Mapping(target = "dateFin", source = "promotion.dateFin"),
            @Mapping(target = "status", source = "promotion.status"),
    })
    PromotionDto toDto(Promotion promotion);

}
