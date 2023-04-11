package converter.impl;

import converter.interfaces.TechniqueConverter;
import dto.CategoryDto;
import dto.ModelDto;
import dto.ProducerDto;
import dto.TechniqueDto;
import entities.Store;
import mapper.impl.*;
import mapper.interfaces.TechniqueMapper;
import org.apache.commons.lang3.StringUtils;
import service.impl.*;
import service.interfaces.*;

import static converter.impl.Constants.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TechniqueConverterImpl implements TechniqueConverter {

    private final TechniqueService techService = new TechniqueServiceImpl();
    private final CategoryService categoryService = new CategoryServiceImpl();
    private final ModelService modelService = new ModelServiceImpl();
    private final StoreService storeService = new StoreServiceImpl();
    private final ProducerService producerService = new ProducerServiceImpl();
    private TechniqueMapper mapper = new TechniqueMapperImpl();

    @Override
    public TechniqueDto convert(HttpServletRequest req) {
        String techId = req.getParameter(TECH_ID);
        String techPrice = req.getParameter(TECH_PRICE);
        String modelId = req.getParameter(MODEL);
        String categoryId = req.getParameter(CATEGORY);
        String producerId = req.getParameter(PRODUCER);
        String[] storesId = req.getParameterValues(STORE_ID);
        TechniqueDto techniqueDto = null;
        if (StringUtils.isNotBlank(techId)) {
            techniqueDto = techService.findById(Integer.parseInt(techId));
        } else {
            techniqueDto = new TechniqueDto();
        }
        techniqueDto.setPrice(StringUtils.isNotBlank(techPrice) ? Double.parseDouble(techPrice) : null);
        ModelDto modelDto = null;
        if (StringUtils.isNotBlank(modelId)) {
            modelDto = modelService.findById(Integer.parseInt(modelId));
        }
        if (techniqueDto.getModel() != null) {
            if (techniqueDto.getModel().getTechniques() != null) {
                techniqueDto.getModel().getTechniques().remove(new ModelMapperImpl().dtoToEntity(modelDto));
            }
        }
        modelDto.getTechniques().add(mapper.dtoToEntity(techniqueDto));
        techniqueDto.setModel(new ModelMapperImpl().dtoToEntity(modelDto));

        CategoryDto categoryDto = null;
        if (StringUtils.isNotBlank(categoryId)) {
            categoryDto = categoryService.findById(Integer.parseInt(categoryId));
        }
        if (techniqueDto.getCategory() != null) {
            if (techniqueDto.getCategory().getTechniques() != null) {
                techniqueDto.getCategory().getTechniques().remove(mapper.dtoToEntity(techniqueDto));
            }
        }
        categoryDto.getTechniques().add(mapper.dtoToEntity(techniqueDto));
        techniqueDto.setCategory(new CategoryMapperImpl().dtoToEntity(categoryDto));


        ProducerDto producerDto = null;
        if (StringUtils.isNotBlank(producerId)) {
            producerDto = producerService.findById(Integer.parseInt(producerId));
        }
        if (techniqueDto.getProducer() != null) {
            if (techniqueDto.getProducer().getTechniques() != null) {
                techniqueDto.getProducer().getTechniques().remove(mapper.dtoToEntity(techniqueDto));
            }
        }
        producerDto.getTechniques().add(mapper.dtoToEntity(techniqueDto));
        techniqueDto.setProducer(new ProducerMapperImpl().dtoToEntity(producerDto));

        Set<Store> stores = new HashSet<>();
        for (String id :
                storesId) {
            if (StringUtils.isNotBlank(id)) {
                stores.add(new StoreMapperImpl().dtoToEntity(storeService.findById(Integer.parseInt(id))));
            }
        }
        List<Store> removeList = new ArrayList<>();
        if (techniqueDto.getStoreList() != null) {
            for (Store store :
                    techniqueDto.getStoreList()) {
                removeList.add(store);
            }
            for (Store store :
                    removeList) {
                store.getTechniques().remove(mapper.dtoToEntity(techniqueDto));
                techniqueDto.getStoreList().remove(store);
            }

            for (
                    Store store :
                    stores) {
                techniqueDto.getStoreList().add(store);
                store.getTechniques().add(mapper.dtoToEntity(techniqueDto));
            }
        } else {
            techniqueDto.setStoreList(stores);
            for (Store store :
                    stores) {
                if (store.getTechniques() != null) {
                    store.getTechniques().add(mapper.dtoToEntity(techniqueDto));
                } else {
                    store.setTechniques(new HashSet<>());
                    store.getTechniques().add(mapper.dtoToEntity(techniqueDto));
                }
            }
        }
        return techniqueDto;
    }

    @Override
    public TechniqueDto convertDelete(HttpServletRequest req) {
        String techId = req.getParameter(TECH_ID);
        TechniqueDto techniqueDto = techService.findById(Integer.parseInt(techId));
        return techniqueDto;
    }
}
