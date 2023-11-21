package ma.yc.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.yc.api.entity.Ville;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CentreDto {
    private Ville ville;
    private String nom;
    private String adresse;
    private String tel;
    private String email;
}
