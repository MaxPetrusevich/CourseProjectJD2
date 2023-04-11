package converter.impl;

import converter.interfaces.StoreConverter;
import dto.StoreDto;
import dto.TypeDto;
import org.apache.commons.lang3.StringUtils;
import service.impl.StoreServiceImpl;
import static converter.impl.Constants.*;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class StoreConverterImpl implements StoreConverter {



    @Override
    public List<StoreDto> convert(HttpServletRequest req) {
        List<StoreDto> stores = new ArrayList<>();
        String id = null;
        String name = null;
        String address = null;
        Integer count = Integer.parseInt(req.getParameter(STORES_COUNT));
        for (int i = 1; i <= count; i++) {
            id = req.getParameter(STORE_ID + i);
            name = req.getParameter(STORE_NAME + i);
            address = req.getParameter(STORE_ADDRESS + i);
            stores.add(StoreDto.builder()
                    .id(StringUtils.isNotBlank(id) ? Integer.parseInt(id) : null)
                    .name(name)
                    .address(address)
                    .build());
        }
        return stores;
    }

    @Override
    public StoreDto convertSingle(HttpServletRequest req) {
        String name = req.getParameter(STORE_NAME);
        String address = req.getParameter(STORE_ADDRESS);
        return StoreDto.builder()
                .name(name)
                .address(address)
                .build();
    }

    @Override
    public List<StoreDto> convertDelete(HttpServletRequest req) {
        String[] storesId = req.getParameterValues(STORE_ID);
        List<StoreDto> stores = new ArrayList<>();
        if (storesId.length > 0) {
            for (String id :
                    storesId) {
                stores.add(new StoreServiceImpl()
                        .findById(StringUtils.isNotBlank(id) ? Integer.parseInt(id) : null));
            }
        }
        return stores;
    }
}
