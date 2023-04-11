package dto;

import entities.Technique;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@EqualsAndHashCode(of = {"id"})
@ToString(exclude = {"techniques"})
public class ProducerDto {
    private Integer id;
    private String name;
    private String country;
    private Set<Technique> techniques;
}
