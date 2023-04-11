package dto;

import entities.Category;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class TypeDto {
    private Integer id;
    private String name;
    private Category category;
}
