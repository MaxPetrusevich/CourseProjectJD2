package command.deleteCommand;

import command.Command;
import converter.impl.CategoryConverterImpl;
import converter.impl.TypeConverterImpl;
import dto.CategoryDto;
import dto.TechniqueDto;
import dto.TypeDto;
import entities.Technique;
import entities.Type;
import mapper.impl.CategoryMapperImpl;
import mapper.impl.TechniqueMapperImpl;
import mapper.impl.TypeMapperImpl;
import service.impl.CategoryServiceImpl;
import service.impl.TechniqueServiceImpl;
import service.impl.TypeServiceImpl;
import service.interfaces.CategoryService;
import service.interfaces.TechniqueService;
import service.interfaces.TypeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static command.Constants.*;

public class CategoryDeleteCommand implements Command {
    private final TypeService typeService = new TypeServiceImpl();
    private final CategoryService categoryService = new CategoryServiceImpl();

    private final TechniqueService techniqueService = new TechniqueServiceImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (GET.equals(req.getMethod())) {
            req.setAttribute(CATEGORIES, categoryService.findAll(new CategoryDto()));
            req.getRequestDispatcher(WEB_INF_JSP_DEL_CATEGORY_DELETE_JSP).forward(req, resp);
        } else {
            List<CategoryDto> categories = new CategoryConverterImpl().convertDelete(req);
            for (CategoryDto category :
                    categories) {
                if (category.getTypes() != null) {
                    for (Type type :
                            category.getTypes()) {
                        type.setCategory(null);
                        typeService.update(new TypeMapperImpl().entityToDto(type));
                    }
                }
                if (category.getTechniques() != null) {
                    for (Technique technique :
                            category.getTechniques()) {
                        technique.setCategory(null);
                        techniqueService.update(new TechniqueMapperImpl().entityToDto(technique));
                    }
                }
                categoryService.delete(category);
            }
            req.getRequestDispatcher(WEB_INF_JSP_DELETE_JSP).forward(req, resp);
        }
    }
}
