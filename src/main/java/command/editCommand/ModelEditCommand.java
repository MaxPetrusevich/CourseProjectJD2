package command.editCommand;

import command.Command;
import converter.impl.ModelConverterImpl;
import dto.CategoryDto;
import dto.ModelDto;
import service.impl.CategoryServiceImpl;
import service.impl.ModelServiceImpl;
import service.impl.TechniqueServiceImpl;
import service.interfaces.TechniqueService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static command.Constants.*;

public class ModelEditCommand implements Command {

    private  final TechniqueService SERVICE = new TechniqueServiceImpl();
    private  final ModelServiceImpl modelService = new ModelServiceImpl();
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(GET.equals(req.getMethod())){
            req.setAttribute(UNIT, SERVICE.findById(Integer.parseInt((String) req.getAttribute(ID))));
            req.getRequestDispatcher(WEB_INF_JSP_EDIT_MODEL_EDIT_JSP).forward(req,resp);
        } else{
            ModelDto modelDto = new ModelConverterImpl().convert(req);
            modelService.update(modelDto);
            req.setAttribute(LIST, SERVICE.findAll());
            req.setAttribute(CATEGORIES, new CategoryServiceImpl().findAll(new CategoryDto()));
            req.getRequestDispatcher(WEB_INF_JSP_LIST_JSP).forward(req,resp);
        }
    }
}
