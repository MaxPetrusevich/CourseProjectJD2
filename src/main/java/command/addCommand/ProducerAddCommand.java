package command.addCommand;

import command.Command;
import converter.impl.ProducerConverterImpl;
import dto.ProducerDto;
import service.impl.ProducerServiceImpl;
import service.interfaces.ProducerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static command.Constants.*;

public class ProducerAddCommand implements Command {
    private final ProducerService producerService = new ProducerServiceImpl();
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (GET.equals(req.getMethod())) {
            req.getRequestDispatcher(WEB_INF_JSP_INSERT_PRODUCER_ADD_JSP).forward(req, resp);
        } else {
            ProducerDto producerDto = new ProducerConverterImpl().convert(req);
            producerService.save(producerDto);
            req.getRequestDispatcher(WEB_INF_JSP_ADD_JSP).forward(req, resp);
        }
    }
}
