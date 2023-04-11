package command.filter;

import command.Command;
import converter.impl.CategoryConverterImpl;
import dto.CategoryDto;
import service.impl.CategoryServiceImpl;
import service.impl.TechniqueServiceImpl;
import service.interfaces.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static command.Constants.*;

public class FindByCategoryCommand implements Command {

    private CategoryService categoryService = new CategoryServiceImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = new CategoryConverterImpl().simpleConvert(req);
        if (id != null) {
            CategoryDto categoryDto = categoryService.findById(id);
            req.setAttribute(CATEGORY, categoryDto);
            req.setAttribute(LIST, categoryDto.getTechniques());
            req.setAttribute(CATEGORIES, new CategoryServiceImpl().findAll(new CategoryDto()));
            req.getRequestDispatcher(WEB_INF_JSP_LIST_JSP).forward(req, resp);
        }else{
            req.setAttribute(SELECT_STATUS, req.getParameter(SELECT_STATUS));
            req.setAttribute(LIST, new TechniqueServiceImpl().findAll());
            req.setAttribute(CATEGORIES, new CategoryServiceImpl().findAll(new CategoryDto()));
            req.getRequestDispatcher(WEB_INF_JSP_LIST_JSP).forward(req, resp);
        }
    }
}
