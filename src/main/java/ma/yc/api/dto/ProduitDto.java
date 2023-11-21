package ma.yc.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProduitDto {
    private String nom ;
    private String description ;
    private String image ;
    private double prix ;
    private int quantite ;
    private long id_centre;
}
