package ma.yc.api.mapper;

import ma.yc.api.dto.CategorieDto;
import ma.yc.api.entity.Categorie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategorieMapper {

    CategorieMapper categorieMapper = Mappers.getMapper(CategorieMapper.class);

    Categorie toEntity(CategorieDto categorieDto);

    CategorieDto toDto(Categorie categorie);
}
