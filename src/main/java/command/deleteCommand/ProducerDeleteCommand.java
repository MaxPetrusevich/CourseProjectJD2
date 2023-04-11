package command.deleteCommand;

import command.Command;
import static command.Constants.*;
import converter.impl.ProducerConverterImpl;
import dto.ProducerDto;
import entities.Technique;
import mapper.impl.TechniqueMapperImpl;
import service.impl.ProducerServiceImpl;
import service.impl.TechniqueServiceImpl;
import service.interfaces.ProducerService;
import service.interfaces.TechniqueService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class ProducerDeleteCommand implements Command {
    private final ProducerService producerService = new ProducerServiceImpl();
    private final TechniqueService techniqueService = new TechniqueServiceImpl();
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(GET.equals(req.getMethod())){
            req.setAttribute(PRODUCERS, producerService.findAll(new ProducerDto()));
            req.getRequestDispatcher(WEB_INF_JSP_DEL_PRODUCER_DELETE_JSP).forward(req,resp);
        } else{
            List<ProducerDto> producers = new ProducerConverterImpl().convertDelete(req);
            for (ProducerDto producer:
                    producers) {
                for (Technique technique:
                        producer.getTechniques()) {
                    technique.setModel(null);
                    techniqueService.update(new TechniqueMapperImpl().entityToDto(technique));
                }
                producerService.delete(producer);
            }
            req.getRequestDispatcher(WEB_INF_JSP_DELETE_JSP).forward(req,resp);
        }
    }
}
