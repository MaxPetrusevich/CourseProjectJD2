package servlet;

import command.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static command.Constants.WEB_INF_JSP_DELETE_JSP;
import static servlet.Constants.*;

@WebServlet("/main")
public class Servlet extends HttpServlet {


    private String command;
    private Command commandExecutor;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        command = req.getParameter(COMMAND);
        req.setAttribute(ROLE, req.getParameter(ROLE));
        req.setAttribute(STATUS, req.getParameter(STATUS));
        commandExecutor = CommandFactory.getInstance().getCommand(command);
        commandExecutor.execute(req, resp);
    }
}



