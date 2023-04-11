package command.deleteCommand;

import command.Command;
import converter.impl.ModelConverterImpl;
import dto.ModelDto;
import static command.Constants.*;

import entities.Technique;
import mapper.impl.TechniqueMapperImpl;
import service.impl.ModelServiceImpl;
import service.impl.TechniqueServiceImpl;
import service.interfaces.ModelService;
import service.interfaces.TechniqueService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class ModelDeleteCommand implements Command {
    private final ModelService modelService = new ModelServiceImpl();
    private final TechniqueService techniqueService = new TechniqueServiceImpl();
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(GET.equals(req.getMethod())){
            req.setAttribute(MODELS, modelService.findAll(new ModelDto()));
            req.getRequestDispatcher(WEB_INF_JSP_DEL_MODEL_DELETE_JSP).forward(req,resp);
        } else{
            List<ModelDto> models = new ModelConverterImpl().convertDelete(req);
            for (ModelDto model:
                 models) {
                for (Technique technique:
                     model.getTechniques()) {
                    technique.setModel(null);
                    techniqueService.update(new TechniqueMapperImpl().entityToDto(technique));
                }
                modelService.delete(model);
            }
            req.getRequestDispatcher(WEB_INF_JSP_DELETE_JSP).forward(req,resp);
        }
    }
}
