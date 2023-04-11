package command;

import authorization.Authorization;
import authorization.AuthorizationImpl;
import dto.CategoryDto;
import lombok.SneakyThrows;
import service.impl.CategoryServiceImpl;
import service.impl.TechniqueServiceImpl;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static command.Constants.*;
import static command.Constants.GET;
import static servlet.Constants.*;
import static servlet.Constants.PASSWORD;

public class LoginAutoCommand implements Command {


    public static final int FIRST_PAGE = 1;
    public static final int RECORDS_PER_PAGE = 3;

    @SneakyThrows
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {


        if (GET.equals(req.getMethod())) {
            req.setAttribute(ACTION, AUTO);
            req.getRequestDispatcher(LOGIN_JSP_WAY).forward(req, resp);
        } else {/*
            req.setAttribute(EMAIL, req.getParameter(EMAIL));
            req.setAttribute(PASSWORD, req.getParameter(PASSWORD));*/
            Authorization authorization = new AuthorizationImpl();
            authorization.signIn(req);

            req.setAttribute(LIST, new TechniqueServiceImpl().findAll());
            req.setAttribute(CATEGORIES, new CategoryServiceImpl().findAll(new CategoryDto()));

            req.getRequestDispatcher(WEB_INF_JSP_LIST_JSP).forward(req, resp);
        }
    }
}
