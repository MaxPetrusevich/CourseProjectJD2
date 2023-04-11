package command.filter;

import command.Command;
import dto.CategoryDto;
import dto.TechniqueDto;
import service.impl.CategoryServiceImpl;
import service.impl.TechniqueServiceImpl;
import service.interfaces.TechniqueService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static command.Constants.*;

public class FindByProducerCommand implements Command {



    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String producer = req.getParameter(PRODUCER);
        TechniqueService techniqueService = new TechniqueServiceImpl();
        List<TechniqueDto> list = techniqueService.findByProducer(producer);
        req.setAttribute(LIST, list);
        req.setAttribute(COUNT, techniqueService.findAll().size());
        req.setAttribute(CATEGORIES, new CategoryServiceImpl().findAll(new CategoryDto()));
        req.getRequestDispatcher(WEB_INF_JSP_LIST_JSP).forward(req,resp);
    }
}
