package ma.yc.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

//@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@MappedSuperclass
public abstract class User  extends AbstractEntity{

    @NotNull
    protected String nom;
    @NotNull
    protected String prenom;
    @Email
    @NotNull
    @Column(unique=true)
    protected String email;
    @NotNull
    protected String password;
    @NotNull
    protected String username;
    @Size(min=0,max=10)
    @Pattern(regexp="(^$|[0-9]{10})")
    protected String telephone;

}
