package command.editCommand;

import command.Command;
import converter.impl.TypeConverterImpl;
import dto.CategoryDto;
import dto.TypeDto;
import service.impl.CategoryServiceImpl;
import service.impl.TechniqueServiceImpl;
import service.impl.TypeServiceImpl;
import service.interfaces.TechniqueService;
import service.interfaces.TypeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static command.Constants.*;

public class TypesEditCommand implements Command {

    private final TechniqueService SERVICE = new TechniqueServiceImpl();
    private final TypeService TYPE_SERVICE = new TypeServiceImpl();
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(GET.equals(req.getMethod())){
            req.setAttribute(UNIT, SERVICE.findById(Integer.parseInt((String) req.getAttribute(ID))));
            req.getRequestDispatcher(WEB_INF_JSP_EDIT_TYPES_EDIT_JSP).forward(req,resp);
        } else{
            List<TypeDto> types = new TypeConverterImpl().convert(req);
            for (TypeDto type:
                 types) {
             TypeDto temp = TYPE_SERVICE.findById(type.getId());
             temp.setName(type.getName());
             TYPE_SERVICE.update(temp);
            }
            req.setAttribute(LIST, SERVICE.findAll());
            req.setAttribute(CATEGORIES, new CategoryServiceImpl().findAll(new CategoryDto()));
            req.getRequestDispatcher(WEB_INF_JSP_LIST_JSP).forward(req,resp);
        }
    }
}
