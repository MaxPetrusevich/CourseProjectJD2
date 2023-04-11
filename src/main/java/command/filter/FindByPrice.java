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

public class FindByPrice implements Command {

    private TechniqueService techniqueService = new TechniqueServiceImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String minPrice = req.getParameter(MIN_PRICE);
        String maxPrice = req.getParameter(MAX_PRICE);
        List<TechniqueDto> list = techniqueService.findByPrice(Double.parseDouble(minPrice), Double.parseDouble(maxPrice));
        req.setAttribute(LIST, list);
        req.setAttribute(COUNT, techniqueService.findAll().size());

        req.setAttribute(CATEGORIES, new CategoryServiceImpl().findAll(new CategoryDto()));

        req.getRequestDispatcher(WEB_INF_JSP_LIST_JSP).forward(req, resp);
    }
}
