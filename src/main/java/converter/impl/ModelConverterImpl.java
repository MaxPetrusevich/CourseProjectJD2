package converter.impl;


import converter.interfaces.ModelConverter;
import dto.ModelDto;
import org.apache.commons.lang3.StringUtils;
import service.impl.ModelServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import static converter.impl.Constants.*;

import java.util.List;

public class ModelConverterImpl implements ModelConverter {



    @Override
    public ModelDto convert(HttpServletRequest req) {
        String id = req.getParameter(MODEL_ID);
        String name = req.getParameter(MODEL_NAME);
        return ModelDto.builder()
                .id(StringUtils.isNotBlank(id) ? Integer.parseInt(id) : null)
                .name(name)
                .build();
    }

    @Override
    public List<ModelDto> convertDelete(HttpServletRequest req) {
        String[] modelsId = req.getParameterValues(MODEL_ID);
        List<ModelDto> models = new ArrayList<>();
        if (modelsId.length > 0) {
            for (String id :
                    modelsId) {
                models.add(new ModelServiceImpl()
                        .findById(StringUtils.isNotBlank(id) ? Integer.parseInt(id) : null));
            }
        }
        return models;
    }
}
