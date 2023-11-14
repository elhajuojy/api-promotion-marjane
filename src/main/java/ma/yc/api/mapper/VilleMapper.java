package ma.yc.api.mapper;

import ma.yc.api.dto.VilleDto;
import ma.yc.api.entity.Ville;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VilleMapper {
    VilleMapper villeMapper = Mappers.getMapper(VilleMapper.class);

    Ville toEntity(VilleDto villeDto);
    VilleDto toDto(Ville ville);
}
