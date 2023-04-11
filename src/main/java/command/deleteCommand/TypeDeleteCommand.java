package command.deleteCommand;

import command.Command;
import converter.impl.ModelConverterImpl;
import converter.impl.TypeConverterImpl;
import static command.Constants.*;
import dto.TypeDto;
import entities.Technique;
import mapper.impl.CategoryMapperImpl;
import mapper.impl.TechniqueMapperImpl;
import service.impl.CategoryServiceImpl;
import service.impl.ModelServiceImpl;
import service.impl.TechniqueServiceImpl;
import service.impl.TypeServiceImpl;
import service.interfaces.CategoryService;
import service.interfaces.TypeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class TypeDeleteCommand implements Command {

    private final TypeService typeService = new TypeServiceImpl();
    private final CategoryService categoryService = new CategoryServiceImpl();
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(GET.equals(req.getMethod())){
            req.setAttribute(TYPES, typeService.findAll(new TypeDto()));
            req.getRequestDispatcher(WEB_INF_JSP_DEL_TYPE_DELETE_JSP).forward(req,resp);
        } else{
           List<TypeDto> types = new TypeConverterImpl().convertDelete(req);
            for (TypeDto type:
                 types) {
                type.getCategory().getTypes().remove(type);
                categoryService.update(new CategoryMapperImpl().entityToDto(type.getCategory()));
                typeService.delete(type);
            }
            req.getRequestDispatcher(WEB_INF_JSP_DELETE_JSP).forward(req,resp);
        }
    }
}
