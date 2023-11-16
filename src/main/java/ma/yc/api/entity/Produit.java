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
public class Produit extends AbstractEntity {

    private String nom ;
    private String description ;
    private String image;
    private double prix;
    private int quantite;
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;
    @ManyToOne
    @JoinColumn(name = "promotion_id")
    private Promotion promotion;

}

