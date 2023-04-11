package command.editCommand;

import command.Command;
import static command.Constants.*;

import converter.impl.CategoryConverterImpl;
import dto.CategoryDto;
import dto.TypeDto;
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


public class CategoryEditCommand implements Command {


    private final TechniqueService SERVICE = new TechniqueServiceImpl();
    private final CategoryService CATEGORY_SERVICE = new CategoryServiceImpl();
    private final TypeService TYPE_SERVICE = new TypeServiceImpl();
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(GET.equals(req.getMethod())){
            req.setAttribute(UNIT, SERVICE.findById(Integer.parseInt((String) req.getAttribute(TECH_ID))));
            req.setAttribute(TYPES, TYPE_SERVICE.findAll(new TypeDto()));
            req.getRequestDispatcher(WEB_INF_JSP_EDIT_CATEGORY_EDIT_JSP).forward(req,resp);
        } else{
            CategoryDto categoryDto = new CategoryConverterImpl().convert(req);
            CATEGORY_SERVICE.update(categoryDto);
            req.setAttribute(LIST, SERVICE.findAll());
            req.setAttribute(CATEGORIES, new CategoryServiceImpl().findAll(new CategoryDto()));
            req.getRequestDispatcher(WEB_INF_JSP_LIST_JSP).forward(req,resp);
        }
    }
}
