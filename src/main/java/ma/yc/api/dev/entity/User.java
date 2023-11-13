package ma.yc.api.dev.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@MappedSuperclass
@Data
public abstract class  User {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    protected Long id;
    protected String nom;
    protected String prenom;
    protected String email;
    protected String password;
    protected String username;
    protected String tel;
    protected String createdAt;
    protected String updatedAt;
}
