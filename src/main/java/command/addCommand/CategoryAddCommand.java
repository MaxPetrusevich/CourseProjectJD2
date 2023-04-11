package command.addCommand;

import command.Command;
import converter.impl.CategoryConverterImpl;
import dto.CategoryDto;
import dto.TypeDto;
import entities.Type;
import mapper.impl.TypeMapperImpl;
import service.impl.CategoryServiceImpl;
import service.impl.TypeServiceImpl;
import service.interfaces.CategoryService;
import service.interfaces.TypeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static command.Constants.*;

public class CategoryAddCommand implements Command {

    private final CategoryService CATEGORY_SERVICE = new CategoryServiceImpl();
    private final TypeService TYPE_SERVICE = new TypeServiceImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (GET.equals(req.getMethod())) {
            req.setAttribute(TYPES, TYPE_SERVICE.findAll(new TypeDto()));
            req.getRequestDispatcher(WEB_INF_JSP_INSERT_CATEGORY_ADD_JSP).forward(req, resp);
        } else {
            CategoryDto categoryDto = new CategoryConverterImpl().convert(req);
            CATEGORY_SERVICE.save(categoryDto);
            for (Type type :
                categoryDto.getTypes()) {
                new TypeServiceImpl().update(new TypeMapperImpl().entityToDto(type));
            }
            req.getRequestDispatcher(WEB_INF_JSP_ADD_JSP).forward(req, resp);
        }
    }
}

