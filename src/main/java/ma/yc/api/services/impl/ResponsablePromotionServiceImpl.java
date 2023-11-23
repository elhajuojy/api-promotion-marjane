package ma.yc.api.services.impl;

import jakarta.transaction.Transactional;
import ma.yc.api.dto.*;
import ma.yc.api.entity.Promotion;
import ma.yc.api.entity.ResponsableRayon;
import ma.yc.api.mappers.ResponsablePromotoinMapper;
import ma.yc.api.repository.PromotionRepository;
import ma.yc.api.repository.ResponsableRayonRepository;
import ma.yc.api.services.ResponsablePromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Transactional
public class ResponsablePromotionServiceImpl implements ResponsablePromotionService {

    private final ResponsableRayonRepository responsableRayonRepository;
    private final PromotionRepository promotionRepository ;
    private ResponsablePromotoinMapper responsablePromotoinMapper ;

    @Autowired
    public ResponsablePromotionServiceImpl(ResponsableRayonRepository responsableRayonRepository, PromotionRepository promotionRepository) {
        this.responsableRayonRepository = responsableRayonRepository;
        this.promotionRepository = promotionRepository;
        this.responsablePromotoinMapper = ResponsablePromotoinMapper.INSTANCE;
    }
    @Override
    public ResponsablePromotionResponse ApprouverOuRefuserPromotion(ResponsablePromotionRequest responsablePromotionRequest) {
        // first find the responsible .
        ResponsablePromotionResponse response  = new ResponsablePromotionResponse();

        this.findResponsableById(responsablePromotionRequest.getResponsableId());

        // :  loop into promotion and update their status
        if (responsablePromotionRequest.getPromotionList().isEmpty()){
            return response;
        }else{
            for(ResponsablePromotionDto promotionDto : responsablePromotionRequest.getPromotionList()){
                Optional<Promotion> promotion = this.promotionRepository.findById(promotionDto.getId());
                if (promotion.isPresent()){
                    promotion.get().setStatus(promotionDto.getStatus());
                    this.promotionRepository.save(promotion.get());
                    response.getPromotionDtos().add(
                            this.responsablePromotoinMapper.toDto(promotion.get()));

                }
//                else{
//                    response.getPromotionDtos().add(promotionDto);
//                }
            }
        }
        return response;
    }

    public ResponsableRayon findResponsableById(Long responsableId){
        if (responsableId <1 ){
            return null;
        }

        Optional<ResponsableRayon> responsable = this.responsableRayonRepository.findById(responsableId);
        return responsable.orElseThrow(
                ()-> new RuntimeException("Responsible not found")
        );
    }
}
