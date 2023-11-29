package ma.yc.api.entity;

import jakarta.persistence.*;
import org.mapstruct.Mapper;

import java.util.Collection;

@Entity
public class Achat extends AbstractEntity{

    private String dateAchat;
    private String montant;
    @OneToMany(mappedBy = "achat")
    private Collection<Produit> produits  ;

    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;




}
