package converter.impl;

import converter.interfaces.TypeConverter;
import dto.TypeDto;
import org.apache.commons.lang3.StringUtils;
import static converter.impl.Constants.*;
import service.impl.TypeServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class TypeConverterImpl implements TypeConverter {




    @Override
    public List<TypeDto> convert(HttpServletRequest req) {
        List<TypeDto> types = new ArrayList<>();
        String id = null;
        String name = null;
        Integer count = Integer.parseInt(req.getParameter(TYPES_COUNT));
        for (int i = 1; i <= count; i++) {
            id = req.getParameter(TYPE_ID + i);
            name = req.getParameter(TYPE_NAME + i);
            types.add(TypeDto.builder()
                    .id(StringUtils.isNotBlank(id) ? Integer.parseInt(id) : null)
                    .name(name)
                    .build());
        }
        return types;
    }

    @Override
    public TypeDto convertSingle(HttpServletRequest req) {
        String name = req.getParameter(TYPE_NAME);
        return TypeDto.builder()
                .name(name)
                .build();
    }

    @Override
    public List<TypeDto> convertDelete(HttpServletRequest req) {
        String[] typesId = req.getParameterValues(TYPE_ID);
        List<TypeDto> types = new ArrayList<>();
        if (typesId.length > 0) {
            for (String id :
                    typesId) {
                types.add(new TypeServiceImpl()
                        .findById(StringUtils.isNotBlank(id) ? Integer.parseInt(id) : null));
            }
        }
        return types;
    }
}
