package ma.yc.api.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.yc.api.enums.StatusPromotion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt;
    private Date updatedAt;
    private Double precentage;
    private String description;
    @Enumerated(EnumType.STRING)
    private StatusPromotion status;
    private Date dateDebut;
    private Date dateFin;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "centre_id")
    private Centre centre;
    @OneToMany(mappedBy = "promotion",fetch = FetchType.LAZY)
    private Collection<Produit> produits = new ArrayList<>() ;

    @OneToMany(mappedBy = "promotion",fetch = FetchType.LAZY)
    private Collection<Categorie> categories = new ArrayList<>() ;



}
