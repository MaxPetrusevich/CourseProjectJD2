package command;

import dto.CategoryDto;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import service.impl.CategoryServiceImpl;
import service.impl.TechniqueServiceImpl;
import service.interfaces.TechniqueService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static command.Constants.*;

public class SelectCommand implements Command {


    @SneakyThrows
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {

        TechniqueService service = new TechniqueServiceImpl();
        req.setAttribute(CATEGORIES, new CategoryServiceImpl().findAll(new CategoryDto()));
        req.setAttribute(COUNT, service.findAll().size());
        req.setAttribute(LIST, service.findAll());
        /*  String pageSize = req.getParameter("pageSize");
        if(pageSize == null){
            req.setAttribute("pageSize", 5);
        } else{
            req.setAttribute("pageSize", Integer.parseInt(pageSize));
        }
        String pageNumber = req.getParameter("pageNumber");
        if(pageNumber == null){
            req.setAttribute("currentPage", 1);
        } else {
            req.setAttribute("currentPage", Integer.parseInt(pageNumber));
        }
        req.setAttribute("list", service.findLimit(Integer.parseInt(StringUtils.isNotBlank(pageNumber)?pageNumber:"1")
                , Integer.parseInt(StringUtils.isNotBlank(pageSize)?pageSize:"5")));*/
        req.getRequestDispatcher(WEB_INF_JSP_LIST_JSP).forward(req,resp);
    }
}
