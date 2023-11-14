package ma.yc.api.mapper;

import ma.yc.api.dto.ProuitStatisticDto;
import ma.yc.api.entity.Produit;
import org.mapstruct.factory.Mappers;

public interface ProuitStatisticMapper {

    PromotionStatistiqueMapper INSTANCE = Mappers.getMapper(PromotionStatistiqueMapper.class);
    ProuitStatisticDto toDto(Produit produit);
}
