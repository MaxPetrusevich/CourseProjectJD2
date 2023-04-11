package converter.interfaces;

import dto.CategoryDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface CategoryConverter {
    CategoryDto convert(HttpServletRequest req);
    List<CategoryDto> convertDelete(HttpServletRequest req);
    Integer simpleConvert(HttpServletRequest req);
}
