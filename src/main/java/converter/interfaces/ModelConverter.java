package converter.interfaces;

import dto.ModelDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ModelConverter {
    ModelDto convert(HttpServletRequest req);

    List<ModelDto> convertDelete(HttpServletRequest req);
}
