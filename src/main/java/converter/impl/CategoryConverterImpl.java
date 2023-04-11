package converter.impl;

import converter.interfaces.CategoryConverter;
import dto.CategoryDto;
import dto.TypeDto;
import entities.Type;
import mapper.impl.CategoryMapperImpl;
import mapper.impl.TypeMapperImpl;
import mapper.interfaces.TypeMapper;
import org.apache.commons.lang3.StringUtils;
import service.impl.CategoryServiceImpl;
import service.impl.TypeServiceImpl;
import service.interfaces.TypeService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

import static converter.impl.Constants.*;

public class CategoryConverterImpl implements CategoryConverter {


    @Override
    public CategoryDto convert(HttpServletRequest req) {
        TypeService service = new TypeServiceImpl();
        TypeMapper mapper = new TypeMapperImpl();
        String id = req.getParameter(CATEGORY_ID);
        String name = req.getParameter(CATEGORY_NAME);
        Set<Type> types = new HashSet<>();
        String[] params = req.getParameterValues(TYPE_ID);
        if(params.length > 0) {
            Set<String> typesId = Arrays.stream(params).collect(Collectors.toSet());

            for (String typeId :
                    typesId) {
                Type temp = mapper.dtoToEntity(service.findById(Integer.parseInt(typeId)));
                types.add(temp);
            }
        }

        return  CategoryDto.builder()
                .id(StringUtils.isNotBlank(id) ? Integer.parseInt(id) : null)
                .name(name)
                .types(types)
                .build();
    }

    @Override
    public List<CategoryDto> convertDelete(HttpServletRequest req) {
        String[] categoriesId = req.getParameterValues(CATEGORY_ID);
        List<CategoryDto> categories = new ArrayList<>();
        if (categoriesId.length > 0) {
            for (String id :
                    categoriesId) {
                categories.add(new CategoryServiceImpl()
                        .findById(StringUtils.isNotBlank(id) ? Integer.parseInt(id) : null));
            }
        }
        return categories;
    }

    @Override
    public Integer simpleConvert(HttpServletRequest req) {
        String id = req.getParameter(CATEGORY);
        Integer findId = StringUtils.isNotBlank(id)?Integer.parseInt(id):null;
        return findId;
    }
}
