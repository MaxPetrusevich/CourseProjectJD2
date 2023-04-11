package converter.interfaces;

import dto.StoreDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface StoreConverter {
    List<StoreDto> convert(HttpServletRequest req);
    StoreDto convertSingle(HttpServletRequest req);

    List<StoreDto> convertDelete(HttpServletRequest req);
}
