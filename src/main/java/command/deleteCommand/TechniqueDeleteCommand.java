package command.deleteCommand;

import command.Command;
import converter.impl.TechniqueConverterImpl;
import dto.TechniqueDto;
import entities.Store;
import mapper.impl.CategoryMapperImpl;
import mapper.impl.ModelMapperImpl;
import mapper.impl.ProducerMapperImpl;
import mapper.impl.StoreMapperImpl;
import service.impl.*;
import service.interfaces.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static command.Constants.*;
import java.util.List;


public class TechniqueDeleteCommand implements Command {


    private final TechniqueService techService = new TechniqueServiceImpl();
    private final CategoryService categoryService = new CategoryServiceImpl();
    private final ModelService modelService = new ModelServiceImpl();
    private final StoreService storeService = new StoreServiceImpl();
    private final ProducerService producerService = new ProducerServiceImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (POST.equals(req.getMethod())) {
            TechniqueDto techniqueDto = new TechniqueConverterImpl().convertDelete(req);
            if (techniqueDto.getCategory() != null) {
                if (techniqueDto.getCategory().getTechniques() != null) {
                    techniqueDto.getCategory().getTechniques().remove(techniqueDto);
                    categoryService.update(new CategoryMapperImpl().entityToDto(techniqueDto.getCategory()));
                }
            }
            if (techniqueDto.getProducer() != null) {
                if (techniqueDto.getProducer().getTechniques() != null) {
                    techniqueDto.getProducer().getTechniques().remove(techniqueDto);
                    producerService.update(new ProducerMapperImpl().entityToDto(techniqueDto.getProducer()));
                }
            }
            if (techniqueDto.getModel() != null) {
                if (techniqueDto.getModel().getTechniques() != null) {
                    techniqueDto.getModel().getTechniques().remove(techniqueDto);
                    modelService.update(new ModelMapperImpl().entityToDto(techniqueDto.getModel()));
                }
            }
            if (techniqueDto.getStoreList() != null) {
                for (Store store :
                        techniqueDto.getStoreList()) {
                    store.getTechniques().remove(techniqueDto);
                    storeService.update(new StoreMapperImpl().entityToDto(store));
                }
            }
            techService.delete(techniqueDto);
            List<TechniqueDto> techniques = techService.findAll();
            req.setAttribute(LIST, techniques);
            req.removeAttribute(TECH_ID);
            req.getRequestDispatcher(WEB_INF_JSP_LIST_JSP).forward(req, resp);
        }
    }
}
