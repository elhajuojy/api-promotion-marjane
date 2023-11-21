package ma.yc.api.services.impl;

import jakarta.transaction.Transactional;
import ma.yc.api.dto.PromotionCentreRequestDto;
import ma.yc.api.dto.PromotionStatistique;
import ma.yc.api.entity.Promotion;
import ma.yc.api.dto.PromotionDto;
import ma.yc.api.mappers.PromotiomMapper;
import ma.yc.api.mappers.StatisticPromotionMapper;
import ma.yc.api.repository.PromotionAuNiveauCentreRepository;
import ma.yc.api.services.PromotiomAuNiveauCentreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;


@Transactional
@Service("PromotiomAuNiveauCentreServiceImpl")
public class PromotiomAuNiveauCentreServiceImp implements PromotiomAuNiveauCentreService {
    private  PromotionAuNiveauCentreRepository promotionAuNiveauCentreRepository;

    @Autowired
    public PromotiomAuNiveauCentreServiceImp(PromotionAuNiveauCentreRepository promotionAuNiveauCentreRepository){
        this.promotionAuNiveauCentreRepository = promotionAuNiveauCentreRepository;
    }

    @Override
    public Collection<PromotionDto> ListPromotion(PromotionCentreRequestDto promotionCentreRequestDto) {
        Collection<PromotionDto> listPromotions = new ArrayList<>();
        Optional<Collection<Promotion>> promotions = promotionAuNiveauCentreRepository.findAllByCentre_id(promotionCentreRequestDto.getCentre_id());
        if (promotions.isPresent()){
            for (Promotion promotion: promotions.get()){
                PromotionDto promotionDto = PromotiomMapper.INSTANCE.toDto(promotion);
                listPromotions.add(promotionDto);
            }
            return listPromotions;
        }
        return null;
    }

    @Override
    public Collection<PromotionStatistique> StatisticPromotionCentre(PromotionCentreRequestDto promotionCentreRequestDto) {
        Collection<PromotionStatistique> promotionStatistiques = new ArrayList<>();
        Optional<Collection<Promotion>> promotions = promotionAuNiveauCentreRepository.findAllByCentre_id(promotionCentreRequestDto.getCentre_id());
        if (promotions.isPresent()){
            for (Promotion promotion: promotions.get()){
                PromotionStatistique promotionStatistique = StatisticPromotionMapper.statisticPromotionMapper.toDto(promotion);
                promotionStatistiques.add(promotionStatistique);
            }
            return promotionStatistiques;
        }
        return null;
    }
}
