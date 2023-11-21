package ma.yc.api.mappers;

import ma.yc.api.dto.AdminCentreDto;
import ma.yc.api.entity.AdminCentre;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminCentreMapper {
    AdminCentreMapper adminCentreMapper = Mappers.getMapper(AdminCentreMapper.class);

    AdminCentre toEntity(AdminCentreDto adminCentreDto);

    AdminCentreDto toDto(AdminCentre adminCentre);

}
