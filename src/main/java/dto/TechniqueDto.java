package dto;

import entities.Category;
import entities.Model;
import entities.Producer;
import entities.Store;
import lombok.*;

import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString(exclude = {"storeList"})
@EqualsAndHashCode(of = {"id"})
public class TechniqueDto {
    private Integer id;
    private Double price;

    private Category category;
    private Model model;
    private Producer producer;
    private Set<Store> storeList;
}
