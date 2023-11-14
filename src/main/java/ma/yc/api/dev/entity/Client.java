package ma.yc.api.dev.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Collection;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@Data
@Builder
public class Client extends User {



}
