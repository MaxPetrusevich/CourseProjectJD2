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
public class ModelDto {
    private Integer id;
    private String name;

    private Set<Technique> techniques;
}
