package ma.yc.api.dev.entity;

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
public class ResponsableRayon extends User {

    @ManyToOne
    private Ville ville;
    @ManyToOne
    @JoinColumn(name="centre_id")
    private Centre  centre;
    @OneToOne
    private Rayon rayon;

}
