package ma.yc.api.mappers;

import ma.yc.api.dto.CentreDto;
import ma.yc.api.entity.Centre;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CentreMapper {
    CentreMapper centreMapper = Mappers.getMapper(CentreMapper.class);

    Centre toEntity(CentreDto centreDto);

    CentreDto toDto(Centre centre);
}
