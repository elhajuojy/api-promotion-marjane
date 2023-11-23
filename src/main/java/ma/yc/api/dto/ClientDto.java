package ma.yc.api.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClientDto {
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String telephone ;
    private String adresse ;
    private String ville ;
}
