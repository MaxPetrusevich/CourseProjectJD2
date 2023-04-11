package command.editCommand;

import command.Command;
import converter.impl.StoreConverterImpl;
import dto.CategoryDto;
import dto.StoreDto;
import service.impl.CategoryServiceImpl;
import service.impl.StoreServiceImpl;
import service.impl.TechniqueServiceImpl;
import service.interfaces.StoreService;
import service.interfaces.TechniqueService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static command.Constants.*;

public class StoreEditCommand implements Command {


    private final TechniqueService SERVICE = new TechniqueServiceImpl();
    private final StoreService STORE_SERVICE = new StoreServiceImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (GET.equals(req.getMethod())) {
            req.setAttribute(UNIT, SERVICE.findById(Integer.parseInt((String) req.getAttribute(ID))));
            req.getRequestDispatcher(WEB_INF_JSP_EDIT_STORE_EDIT_JSP).forward(req, resp);
        } else {
            List<StoreDto> stores = new StoreConverterImpl().convert(req);
            for (StoreDto store : stores) {
                StoreDto temp = STORE_SERVICE.findById(store.getId());
                temp.setName(store.getName());
                temp.setAddress(store.getAddress());
                STORE_SERVICE.update(temp);
            }
            req.setAttribute(LIST, SERVICE.findAll());
            req.setAttribute(CATEGORIES, new CategoryServiceImpl().findAll(new CategoryDto()));
            req.getRequestDispatcher(WEB_INF_JSP_LIST_JSP).forward(req, resp);
        }
    }
}
