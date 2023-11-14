package ma.yc.api.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name = "admin_centre")
public class AdminCentre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    @ManyToOne
    private Ville ville ;
    @OneToOne
    private Centre centre ;

}
