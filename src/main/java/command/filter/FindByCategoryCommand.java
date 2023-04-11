package command.filter;

import command.Command;
import converter.impl.CategoryConverterImpl;
import dto.CategoryDto;
import service.impl.CategoryServiceImpl;
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
        CategoryDto categoryDto = categoryService.findById(id);
        req.setAttribute(SELECT_STATUS, req.getParameter(SELECT_STATUS));
        req.setAttribute(CATEGORY, categoryDto);
        req.setAttribute(LIST, categoryDto.getTechniques());
        req.setAttribute(COUNT, categoryDto.getTechniques().size());
        req.setAttribute(CATEGORIES, categoryService.findAll(categoryDto));
        req.getRequestDispatcher(WEB_INF_JSP_LIST_JSP).forward(req,resp);
    }
}
