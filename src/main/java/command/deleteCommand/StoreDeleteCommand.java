package command.deleteCommand;

import command.Command;
import converter.impl.StoreConverterImpl;
import static command.Constants.*;
import dto.StoreDto;
import dto.TypeDto;
import entities.Technique;
import mapper.impl.CategoryMapperImpl;
import mapper.impl.TechniqueMapperImpl;
import service.impl.TechniqueServiceImpl;
import service.impl.StoreServiceImpl;
import service.interfaces.StoreService;
import service.interfaces.TechniqueService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class StoreDeleteCommand implements Command {
    private final StoreService storeService = new StoreServiceImpl();
    private final TechniqueService techniqueService = new TechniqueServiceImpl();
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(GET.equals(req.getMethod())){
            req.setAttribute(TYPES, storeService.findAll(new StoreDto()));
            req.getRequestDispatcher(WEB_INF_JSP_DEL_STORE_DELETE_JSP).forward(req,resp);
        } else{
            List<StoreDto> stores = new StoreConverterImpl().convertDelete(req);
            for (StoreDto store:
                    stores) {
                for (Technique technique :
                store.getTechniques()) {
                    technique.getStoreList().remove(store);
                    techniqueService.update(new TechniqueMapperImpl().entityToDto(technique));
                }
                storeService.delete(store);
            }
            req.getRequestDispatcher(WEB_INF_JSP_DELETE_JSP).forward(req,resp);
        }
    }
}
