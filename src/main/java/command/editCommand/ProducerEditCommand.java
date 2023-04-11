package command.editCommand;

import command.Command;
import converter.impl.ProducerConverterImpl;
import dto.CategoryDto;
import dto.ProducerDto;
import service.impl.CategoryServiceImpl;
import service.impl.ProducerServiceImpl;
import service.impl.TechniqueServiceImpl;
import service.interfaces.ProducerService;
import service.interfaces.TechniqueService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


import static command.Constants.*;

public class ProducerEditCommand implements Command {

    private  final TechniqueService SERVICE = new TechniqueServiceImpl();
    private  final ProducerService PRODUCER_SERVICE = new ProducerServiceImpl();
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(GET.equals(req.getMethod())){
            req.setAttribute(UNIT, SERVICE.findById(Integer.parseInt((String) req.getAttribute(ID))));
            req.getRequestDispatcher(WEB_INF_JSP_EDIT_PRODUCER_EDIT_JSP).forward(req,resp);
        } else{
            ProducerDto producerDto = new ProducerConverterImpl().convert(req);
            PRODUCER_SERVICE.update(producerDto);
            req.setAttribute(LIST, SERVICE.findAll());
            req.setAttribute(CATEGORIES, new CategoryServiceImpl().findAll(new CategoryDto()));
            req.getRequestDispatcher(WEB_INF_JSP_LIST_JSP).forward(req,resp);
        }
    }
}
