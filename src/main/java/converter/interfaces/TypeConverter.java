package converter.interfaces;

import dto.TypeDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface TypeConverter {
    List<TypeDto> convert(HttpServletRequest req);
    TypeDto convertSingle(HttpServletRequest req);

    List<TypeDto> convertDelete(HttpServletRequest req);
}
