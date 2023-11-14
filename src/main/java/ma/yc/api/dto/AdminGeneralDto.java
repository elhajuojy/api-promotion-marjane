package ma.yc.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AdminGeneralDto {
    private String username;
    private String nom;
    private String prenom;
    private String email;
    private String password;

}
