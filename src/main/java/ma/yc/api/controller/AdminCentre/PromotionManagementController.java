package ma.yc.api.controller.AdminCentre;

import jakarta.validation.Valid;
import ma.yc.api.controller.Promotion.PromotionManger;
import ma.yc.api.dto.PromotionCentreRequestDto;
import ma.yc.api.services.PromotionCentreService;
import ma.yc.api.services.PromotionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin_centres/promotions")
public class PromotionManagementController {

    PromotionManger promotionManger;
    private PromotionCentreService promotionService;

    public PromotionManagementController(PromotionManger promotionManger, PromotionCentreService promotionService) {
        this.promotionManger = promotionManger;
        this.promotionService = promotionService;
    }

    @PostMapping
    public void addPromotion(@RequestBody @Valid PromotionCentreRequestDto promotionCentreRequestDto ,
                             @RequestHeader("Authorization") String token
                             ){
        if(this.promotionService.addPromotion(promotionCentreRequestDto) !=null){
            this.promotionManger.notifyPromotion();
        }

    }

}
