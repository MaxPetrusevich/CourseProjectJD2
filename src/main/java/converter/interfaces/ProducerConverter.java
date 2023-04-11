package converter.interfaces;

import dto.ProducerDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ProducerConverter {
    ProducerDto convert(HttpServletRequest req);
    List<ProducerDto> convertDelete(HttpServletRequest req);
}
