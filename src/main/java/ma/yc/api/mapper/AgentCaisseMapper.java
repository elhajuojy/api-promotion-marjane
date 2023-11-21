package ma.yc.api.mapper;

import ma.yc.api.dto.AgentCaisseDto;
import ma.yc.api.entity.AgentCaisse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AgentCaisseMapper {
    AgentCaisseMapper INSTANCE = Mappers.getMapper(AgentCaisseMapper.class);

    AgentCaisse toEntity(AgentCaisseDto agentCaisseDto);
    AgentCaisseDto toDto(AgentCaisse agentCaisse);

}
