package ma.yc.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class AgentCaisseDto {

    @NotBlank
    private String nom;
    @NotBlank
    private String prenom;
    @Email
    private String email;
    @NotBlank
    @Pattern(regexp = "^\\+212[5-7][0-9]{8}$")
    private String telephone;
    @NotBlank
//    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&*_-])[A-Za-z\\d@#$%^&*_-]{12,}$\n")
    private String password;
}
