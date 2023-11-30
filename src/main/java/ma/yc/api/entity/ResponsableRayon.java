package ma.yc.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name="responsable_rayon")
public class ResponsableRayon extends AbstractEntity{

    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String username;
    @ManyToOne
    private Ville ville;
    @ManyToOne
    @JoinColumn(name="centre_id")
    private Centre  centre;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rayon_id", referencedColumnName = "id")
    private Rayon rayon;

}
