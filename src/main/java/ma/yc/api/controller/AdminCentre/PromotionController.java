package ma.yc.api.controller.AdminCentre;

import jakarta.validation.Valid;
import ma.yc.api.dto.PromotionCentreRequestDto;
import ma.yc.api.dto.PromotionDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/admin_centres/promotions")
public class PromotionController {

    @PostMapping
    public void addPromotion(@RequestBody @Valid PromotionCentreRequestDto promotionCentreRequestDto , @RequestHeader("Authorization") String token
                             ){



    }

}
