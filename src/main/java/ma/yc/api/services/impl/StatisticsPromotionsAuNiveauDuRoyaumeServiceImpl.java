package ma.yc.api.services.impl;

import jakarta.transaction.Transactional;
import ma.yc.api.dto.PromotionStatistique;
import ma.yc.api.dto.PromotionStatistiques;
import ma.yc.api.entity.Promotion;
import ma.yc.api.enums.StatusPromotion;
import ma.yc.api.mappers.PromotionStatistiqueMapper;
import ma.yc.api.repository.StatisticsPromotionsAuNiveauDuRoyaumeRepository;
import ma.yc.api.services.StatisticsPromotionsAuNiveauDuRoyaumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
@Transactional
public class StatisticsPromotionsAuNiveauDuRoyaumeServiceImpl implements StatisticsPromotionsAuNiveauDuRoyaumeService {




    private  StatisticsPromotionsAuNiveauDuRoyaumeRepository statisticsPromotionsAuNiveauDuRoyaumeRepository ;
    private final PromotionStatistiqueMapper promotionStatistiqueMapper;

    @Autowired
    public StatisticsPromotionsAuNiveauDuRoyaumeServiceImpl(StatisticsPromotionsAuNiveauDuRoyaumeRepository statisticsPromotionsAuNiveauDuRoyaumeRepository  ) {
        this.statisticsPromotionsAuNiveauDuRoyaumeRepository = statisticsPromotionsAuNiveauDuRoyaumeRepository;
        this.promotionStatistiqueMapper = PromotionStatistiqueMapper.INSTANCE;
    }


    @Transactional
    @Override
    public Collection<PromotionStatistiques> getStatisticsPromotionsAuNiveauDuRoyaume(String... status) {


        // TODO: 7/11/2023 get all promotion than you need to map them as wanted .

        Collection<PromotionStatistiques> promotionStatistiques = new ArrayList<>();
        if (status.length ==0){
           promotionStatistiques.add(getStatisticsPromotionsAuNiveauDuRoyaumeByStatus(StatusPromotion.ACCPETER));
           promotionStatistiques.add(getStatisticsPromotionsAuNiveauDuRoyaumeByStatus(StatusPromotion.REFUSER));
           promotionStatistiques.add(getStatisticsPromotionsAuNiveauDuRoyaumeByStatus(StatusPromotion.EN_ATTENTE));

       }else {
           StatusPromotion statusPromotion = StatusPromotion.valueOf(status[0]);
           promotionStatistiques.add(getStatisticsPromotionsAuNiveauDuRoyaumeByStatus(statusPromotion));
       }


        return promotionStatistiques;



    }

    private PromotionStatistiques getStatisticsPromotionsAuNiveauDuRoyaumeByStatus(StatusPromotion statusPromotion) {
        Optional<Collection<Promotion>> promotionsList =  this.statisticsPromotionsAuNiveauDuRoyaumeRepository.findAllByStatus(statusPromotion);
        Collection<PromotionStatistique> promotionStatistiques = new ArrayList<>();

        if (promotionsList.isPresent()){
            for (Promotion promotion : promotionsList.get()){
                PromotionStatistique promotionStatistique  = this.promotionStatistiqueMapper.toDto(promotion);
                promotionStatistiques.add(promotionStatistique);
            }
            
            PromotionStatistiques promotionStatistiquesList = new PromotionStatistiques();
            promotionStatistiquesList.setSize(promotionsList.get().size());
            promotionStatistiquesList.setStatus(statusPromotion);
            promotionStatistiquesList.getPromoitons().addAll(promotionStatistiques);

            return promotionStatistiquesList;
        }
        return null;
    }
}
