package ma.yc.api.mapper;

import ma.yc.api.dto.ProduitDto;
import ma.yc.api.entity.Produit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProduitMapper {
    ProduitMapper produitMapper = Mappers.getMapper(ProduitMapper.class);

//    @Mapping(target = "id",source ="produitDto.id" )
    Produit toEntity(ProduitDto produitDto);

//    @Mapping(target = "id",source = "produit.id")
    ProduitDto toDto(Produit produit);
}
