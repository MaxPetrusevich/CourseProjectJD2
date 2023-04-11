package command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static servlet.Constants.*;

public class UpdateCommand implements Command{
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (GET.equals(req.getMethod())) {
            req.setAttribute(TEC_ID, req.getParameter(TEC_ID));
            req.getRequestDispatcher(UPDATE_JSP_WAY).forward(req, resp);
        }
    }
}
