package dto;

import entities.Technique;
import lombok.*;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString(exclude = {"techniques"})
public class StoreDto {
    private Integer id;
    private String name;
    private String address;
    private Set<Technique> techniques;
}
