package ma.yc.api.dev.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor

@Data
@Entity
@Table(name = "admin_general")
public class AdminGeneral extends User  {

}
