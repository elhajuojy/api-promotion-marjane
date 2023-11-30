package ma.yc.api.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rayon")
@Data
public class Rayon extends AbstractEntity {

    private String nom;
    private String description;
    private String image;
    private String slug;
    @ManyToOne
    private Categorie categorie;
    @OneToOne(mappedBy = "rayon")
    private ResponsableRayon responsableRayon;

    @ManyToOne
    private Centre centre;

}
