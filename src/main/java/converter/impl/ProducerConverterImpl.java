package converter.impl;

import converter.interfaces.ProducerConverter;
import dto.ModelDto;
import dto.ProducerDto;
import org.apache.commons.lang3.StringUtils;
import static converter.impl.Constants.*;

import service.impl.ProducerServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class ProducerConverterImpl implements ProducerConverter {



    @Override
    public ProducerDto convert(HttpServletRequest req) {
        String id = req.getParameter(PRODUCER_ID);
        String name = req.getParameter(PRODUCER_NAME);
        String country = req.getParameter(PRODUCER_COUNTRY);
        return ProducerDto.builder()
                .id(StringUtils.isNotBlank(id)?Integer.parseInt(id):null)
                .name(name)
                .country(country)
                .build();
    }

    @Override
    public List<ProducerDto> convertDelete(HttpServletRequest req) {
        String[] producersId = req.getParameterValues(PRODUCER_ID);
        List<ProducerDto> producers = new ArrayList<>();
        if (producersId.length > 0) {
            for (String id :
                    producersId) {
                producers.add(new ProducerServiceImpl()
                        .findById(StringUtils.isNotBlank(id) ? Integer.parseInt(id) : null));
            }
        }
        return producers;
    }
}
