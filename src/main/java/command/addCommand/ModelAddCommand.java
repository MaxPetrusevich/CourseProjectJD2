package command.addCommand;

import command.Command;
import converter.impl.ModelConverterImpl;
import dto.ModelDto;
import service.impl.ModelServiceImpl;
import service.interfaces.ModelService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static command.Constants.*;

public class ModelAddCommand implements Command {
    private  final ModelService modelService = new ModelServiceImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(GET.equals(req.getMethod())){
            req.getRequestDispatcher(WEB_INF_JSP_INSERT_MODEL_ADD_JSP).forward(req,resp);
        } else{
            ModelDto modelDto = new ModelConverterImpl().convert(req);
            modelService.save(modelDto);
            req.getRequestDispatcher(WEB_INF_JSP_ADD_JSP).forward(req,resp);
        }
    }
}
