package ma.yc.api.services;

import ma.yc.api.dto.PromotionDto;
import org.springframework.data.domain.Page;

import java.util.Collection;

public interface PagablePromotionService {

    public Page<PromotionDto> getAll(Integer page, Integer size);
}
