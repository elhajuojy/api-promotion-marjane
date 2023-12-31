package ma.yc.api.controller.ResponsableRayonController;


import ma.yc.api.dto.PromotionDto;
import ma.yc.api.services.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/responsables-rayon")
public class ConstulerListPromotionController {

    private PromotionService promotionService;

    @Autowired
    public ConstulerListPromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    // TODO: 16/11/2023 consulterListPromotionPourResponsableRayon

    @GetMapping("/promotions")
    public ResponseEntity<Collection<PromotionDto>> consulterListPromotion(@RequestHeader("Authorization") String token){
        return ResponseEntity.ok(promotionService.consulterListPromotionPourResponsableRayon(1));
    }

    @GetMapping("/{id}/promotions")
    public ResponseEntity<Collection<PromotionDto>> consulterListPromotionParId(@RequestHeader("Authorization") String token, @PathVariable("id") int id){
            return ResponseEntity.ok(promotionService.consulterListPromotionPourResponsableRayon(id));
    }



}
