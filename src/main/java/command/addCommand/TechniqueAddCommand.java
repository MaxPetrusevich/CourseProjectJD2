package command.addCommand;

import command.Command;
import converter.impl.TechniqueConverterImpl;
import dto.*;
import static command.Constants.*;
import service.impl.*;
import service.interfaces.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class TechniqueAddCommand implements Command {

    private final TechniqueService techService = new TechniqueServiceImpl();
    private final CategoryService categoryService = new CategoryServiceImpl();
    private final ModelService modelService = new ModelServiceImpl();
    private final StoreService storeService = new StoreServiceImpl();
    private final ProducerService producerService = new ProducerServiceImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (GET.equals(req.getMethod())) {
            req.setAttribute(CATEGORIES, categoryService.findAll(new CategoryDto()));
            req.setAttribute(MODELS, modelService.findAll(new ModelDto()));
            req.setAttribute(PRODUCERS, producerService.findAll(new ProducerDto()));
            req.setAttribute(STORES, storeService.findAll(new StoreDto()));
            req.getRequestDispatcher(WEB_INF_JSP_INSERT_TEC_ADD_JSP).forward(req, resp);
        } else {
            TechniqueDto techniqueDto = new TechniqueConverterImpl().convert(req);
            techService.create(techniqueDto);
            req.setAttribute(CATEGORIES, new CategoryServiceImpl().findAll(new CategoryDto()));
            //req.setAttribute("count", techService.findAll().size());
            req.setAttribute(LIST, techService.findAll());
           /* String pageSize = req.getParameter("pageSize");
            if (pageSize == null) {
                req.setAttribute("pageSize", 5);
            } else {
                req.setAttribute("pageSize", Integer.parseInt(pageSize));
            }
            String pageNumber = req.getParameter("pageNumber");
            if (pageNumber == null) {
                req.setAttribute("currentPage", 1);
            } else {
                req.setAttribute("currentPage", Integer.parseInt(pageNumber));
            }
            req.setAttribute("list", techService.findLimit(Integer.parseInt(StringUtils.isNotBlank(pageNumber) ? pageNumber : "1")
                    , Integer.parseInt(StringUtils.isNotBlank(pageSize) ? pageSize : "5")));*/
            req.getRequestDispatcher(WEB_INF_JSP_LIST_JSP).forward(req, resp);
        }
    }
}

