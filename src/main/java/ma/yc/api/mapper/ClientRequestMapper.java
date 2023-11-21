package ma.yc.api.mapper;

import ma.yc.api.dto.ClientRequestDto;
import ma.yc.api.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientRequestMapper {
    ClientRequestMapper INSTANCE  = Mappers.getMapper(ClientRequestMapper.class);


    Client toEntity(ClientRequestDto clientRequestDto);
    ClientRequestDto toDto(Client client);


}
