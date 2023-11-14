package ma.yc.api.mapper;

import ma.yc.api.dto.AdminGeneralDto;
import ma.yc.api.entity.AdminGeneral;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminGeneralMapper {
    AdminGeneralMapper adminGeneralMapper = Mappers.getMapper(AdminGeneralMapper.class);

    AdminGeneral toEntity(AdminGeneralDto adminGeneralDto);

    AdminGeneralDto toDto(AdminGeneral adminGeneral);
}
