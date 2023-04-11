package dto;

import entities.Technique;
import entities.Type;
import lombok.*;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString(exclude = {"types", "techniques"})
public class CategoryDto {
    private Integer id;
    private String name;

    private Set<Type> types;
    private Set<Technique> techniques;
}
