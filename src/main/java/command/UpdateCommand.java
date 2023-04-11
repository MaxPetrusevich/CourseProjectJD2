package command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static command.Constants.TECH_ID;
import static servlet.Constants.*;

public class UpdateCommand implements Command{
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (GET.equals(req.getMethod())) {
            req.setAttribute(TECH_ID, req.getParameter(TECH_ID));
            req.getRequestDispatcher(UPDATE_JSP_WAY).forward(req, resp);
        }
    }
}
