package ma.yc.api.dev.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "rayon")
public class Rayon {
    @Id
    private int id;
    private String nom;
    private String description;
    private String image;
    @OneToOne(mappedBy = "rayon")
    private Categorie categorie;
    @OneToOne
    private ResponsableRayon responsableRayon;

    @ManyToOne
    private Centre centre;

}
