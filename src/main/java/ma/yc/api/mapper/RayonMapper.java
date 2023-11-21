package ma.yc.api.mapper;

import ma.yc.api.dto.RayonDto;
import ma.yc.api.entity.Rayon;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface RayonMapper {
    RayonMapper rayonMapper = Mappers.getMapper(RayonMapper.class);

    Rayon toEntity(RayonDto rayonDto);
    RayonDto toDto(Rayon rayon);
}
