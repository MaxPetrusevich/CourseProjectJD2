package command.addCommand;

import command.Command;
import converter.impl.TypeConverterImpl;
import dto.TypeDto;
import service.impl.TypeServiceImpl;
import service.interfaces.TypeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static command.Constants.*;

public class TypeAddCommand implements Command {
    private final TypeService typeService = new TypeServiceImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (GET.equals(req.getMethod())) {
            req.getRequestDispatcher(WEB_INF_JSP_INSERT_TYPE_ADD_JSP).forward(req, resp);
        } else {
            TypeDto typeDto = new TypeConverterImpl().convertSingle(req);
            typeService.save(typeDto);
            req.getRequestDispatcher(WEB_INF_JSP_ADD_JSP).forward(req, resp);
        }
    }
}
