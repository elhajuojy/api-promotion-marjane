package ma.yc.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public  class  User {

    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String username;
}
