package command.editCommand;

import command.Command;
import converter.impl.TechniqueConverterImpl;
import dto.*;
import service.impl.*;
import service.interfaces.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static command.Constants.*;

public class TechEditCommand implements Command {


    private final TechniqueService techService = new TechniqueServiceImpl();
    private final CategoryService categoryService = new CategoryServiceImpl();
    private final ModelService modelService = new ModelServiceImpl();
    private final StoreService storeService = new StoreServiceImpl();
    private final ProducerService producerService = new ProducerServiceImpl();
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(GET.equals(req.getMethod())){
            req.setAttribute(UNIT, techService.findById(Integer.parseInt((String) req.getAttribute(TECH_ID))));
            req.setAttribute(CATEGORIES, categoryService.findAll(new CategoryDto()));
            req.setAttribute(MODELS, modelService.findAll(new ModelDto()));
            req.setAttribute(PRODUCERS, producerService.findAll(new ProducerDto()));
            req.setAttribute(STORES, storeService.findAll(new StoreDto()));
            req.getRequestDispatcher(WEB_INF_JSP_EDIT_TEC_EDIT_JSP).forward(req,resp);
        } else{
            TechniqueDto techniqueDto = new TechniqueConverterImpl().convert(req);
            techService.update(techniqueDto);
            req.setAttribute(LIST, techService.findAll());
            req.setAttribute(CATEGORIES, new CategoryServiceImpl().findAll(new CategoryDto()));
            req.getRequestDispatcher(WEB_INF_JSP_LIST_JSP).forward(req,resp);
        }
    }
}
