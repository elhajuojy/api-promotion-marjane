package ma.yc.api.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rayon {
    @Id
    private int id;
    private String nom;
    private String description;
    private String image;
    @OneToOne(mappedBy = "rayon")
    private Categorie categorie;
    @OneToOne
    private Responsable responsable;

    @ManyToOne
    private Centre centre;

}
