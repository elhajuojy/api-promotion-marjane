package ma.yc.api.controller.AdminCentre;

import ma.yc.api.dto.PromotionCentreRequestDto;
import ma.yc.api.dto.PromotionDto;
import ma.yc.api.dto.PromotionStatistique;
import ma.yc.api.services.PromotiomAuNiveauCentreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/statistics/promotion/centre")
public class StatistiquePromotionAuNiveauCentreController {

    private  PromotiomAuNiveauCentreService PromotiomAuNiveauCentreService;

    @Autowired
    public StatistiquePromotionAuNiveauCentreController( PromotiomAuNiveauCentreService promotiomAuNiveauCentreService) {
        PromotiomAuNiveauCentreService = promotiomAuNiveauCentreService;
    }


    @GetMapping()
    public Collection<PromotionDto> listPromotion(@PathVariable PromotionCentreRequestDto promotionCentreRequestDto) {
        return this.PromotiomAuNiveauCentreService.ListPromotion(promotionCentreRequestDto);
    }
    @PostMapping()
    public Collection<PromotionStatistique> StatisticPromotionCentre(@RequestBody PromotionCentreRequestDto promotionCentreRequestDto){
         return this.PromotiomAuNiveauCentreService.StatisticPromotionCentre(promotionCentreRequestDto);
    }
}
