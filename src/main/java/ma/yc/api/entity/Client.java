package ma.yc.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Client  extends User{

    private String adresse;
    private String ville;
    private String codePostal;
    @OneToOne
    @JoinColumn(name = "fidelite_id", referencedColumnName = "id")
    private Fidelite fidelite ;
    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
    private Collection<Achat> historiqueAchats = new ArrayList<>();

}
