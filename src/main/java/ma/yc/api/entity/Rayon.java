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
public class Rayon extends AbstractEntity {

    private String nom;
    private String description;
    private String image;
    private String slug;
    @ManyToOne
    private Categorie categorie;
    @OneToOne
    private ResponsableRayon responsableRayon;

    @ManyToOne
    private Centre centre;

}
