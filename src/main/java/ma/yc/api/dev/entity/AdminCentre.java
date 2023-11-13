package ma.yc.api.dev.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name = "admin_centre")
public class AdminCentre extends  User{

    @ManyToOne
    private Ville ville ;
    @OneToOne
    private Centre centre ;

}
