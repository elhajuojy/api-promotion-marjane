package ma.yc.api.services.impl;

import ma.yc.api.dto.PromotionCentreRequestDto;
import ma.yc.api.dto.PromotionDto;
import ma.yc.api.exceptions.business.NotFoundException;
import ma.yc.api.mapper.PromotionCentreMapper;
import ma.yc.api.mapper.PromotionMapper;
import ma.yc.api.repository.PromotionRepository;
import ma.yc.api.services.PromotionCentreService;
import org.springframework.stereotype.Service;

@Service
public class PromotionCentreServiceImpl implements PromotionCentreService {

    private PromotionRepository promotionRepository;
    private PromotionCentreMapper promotionCentreMapper;
    private PromotionMapper promotionMapper;

    public PromotionCentreServiceImpl(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
        this.promotionCentreMapper = PromotionCentreMapper.INSTANCE;
        this.promotionMapper = PromotionMapper.INSTANCE;
    }

    @Override
    public PromotionCentreRequestDto addPromotion(PromotionCentreRequestDto promotionCentreRequestDto) {

        PromotionDto promotionDto = promotionCentreRequestDto.getPromotion();
        return this.promotionCentreMapper.toDto(this.promotionRepository.save(this.promotionMapper.toEntity(promotionDto)));
    }

    @Override
    public void deletePromotion(Long id) {
        this
                .promotionRepository.findById(id).orElseThrow(()-> new NotFoundException("this promotion does not exists "));
        this.promotionRepository.deleteById(id);

    }

    @Override
    public void updatePromotion(PromotionCentreRequestDto promotionCentreRequestDto) {
        PromotionDto promotionDto = promotionCentreRequestDto.getPromotion();
        this.promotionRepository.findById(promotionDto.getId()).orElseThrow(()-> new NotFoundException("this promotion does not exists "));
        this.promotionRepository.save(this.promotionMapper.toEntity(promotionDto));
    }
}
