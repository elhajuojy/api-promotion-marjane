package ma.yc.api.mappers;

import ma.yc.api.dto.ProduitDto;
import ma.yc.api.entity.Produit;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProduitMapper {
    ProduitMapper INSTANCE = Mappers.getMapper(ProduitMapper.class);

    Produit toEntity(ProduitDto produitDto);

    ProduitDto toDto(Produit produit);
}
