package command.filter;

import command.Command;
import dto.CategoryDto;
import service.impl.CategoryServiceImpl;
import service.impl.TechniqueServiceImpl;
import service.interfaces.TechniqueService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static command.Constants.*;

public class SortAscCommand implements Command {


    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TechniqueService techniqueService = new TechniqueServiceImpl();
        req.setAttribute(CATEGORIES, new CategoryServiceImpl().findAll(new CategoryDto()));
        req.setAttribute(COUNT, techniqueService.findAll().size());
        req.setAttribute(LIST, techniqueService.orderByPriceAsc());
        req.getRequestDispatcher(WEB_INF_JSP_LIST_JSP).forward(req,resp);

    }
}
