package ma.yc.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProuitStatisticDto {
    private String nom ;
    private double prix ;
    private int quantite ;
}
