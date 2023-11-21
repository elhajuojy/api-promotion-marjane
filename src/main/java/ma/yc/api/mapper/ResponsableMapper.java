package ma.yc.api.mapper;

import ma.yc.api.dto.ResponsableDto;
import ma.yc.api.entity.ResponsableRayon;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ResponsableMapper {
    ResponsableMapper Instance = Mappers.getMapper(ResponsableMapper.class);

    ResponsableRayon toEntity(ResponsableDto responsableDto);

    ResponsableDto toDto(ResponsableRayon responsableRayon);
}
