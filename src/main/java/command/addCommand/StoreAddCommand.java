package command.addCommand;

import command.Command;
import converter.impl.StoreConverterImpl;
import dto.StoreDto;
import service.impl.StoreServiceImpl;
import service.interfaces.StoreService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static command.Constants.*;
public class StoreAddCommand implements Command {
    private final StoreService storeService = new StoreServiceImpl();
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (GET.equals(req.getMethod())) {
            req.getRequestDispatcher(WEB_INF_JSP_INSERT_STORE_ADD_JSP).forward(req, resp);
        } else {
            StoreDto storeDto = new StoreConverterImpl().convertSingle(req);
            storeService.save(storeDto);
            req.getRequestDispatcher(WEB_INF_JSP_ADD_JSP).forward(req, resp);
        }
    }
}
