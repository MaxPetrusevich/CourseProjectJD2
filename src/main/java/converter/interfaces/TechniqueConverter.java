package converter.interfaces;

import dto.TechniqueDto;

import javax.servlet.http.HttpServletRequest;

public interface TechniqueConverter {
    TechniqueDto convert(HttpServletRequest req);
    TechniqueDto convertDelete(HttpServletRequest req);
}
