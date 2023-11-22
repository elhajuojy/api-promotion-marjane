package ma.yc.api.controller.Promotion;


import lombok.extern.log4j.Log4j2;
import ma.yc.api.dto.ProduitDto;
import ma.yc.api.dto.PromotionDto;
import ma.yc.api.exceptions.business.NotFoundException;
import ma.yc.api.services.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/promotions")
@Log4j2
public class PromotionController implements PromotionListner{

    private PromotionService promotionService;
    private PromotionManger promotionManger;

    @Autowired
    public PromotionController(PromotionService promotionService, PromotionManger promotionManger) {
        this.promotionService = promotionService;
        this.promotionManger = promotionManger;
        this.promotionManger.registerListener(this);

    }

    @GetMapping
    public List<PromotionDto> getAll() throws ExecutionException, InterruptedException {
//        throw new RuntimeException("not implemented yet");
        return this.getAllPromotion().get();

    }

    @GetMapping("/{id}/produits")
    public List<ProduitDto> getProduits(@PathVariable("id") Long id){
        // TODO: 15/11/2023 implement this method
//        return this.promotionService.getProduits(id);
        return null;

    }

    @PostMapping("/product")
    public ResponseEntity<?> promotionProduct(@RequestBody ProduitDto produitDto, PromotionDto promotionDto){
        try{
            produitDto = this.promotionService.addPromotion(produitDto,promotionDto);
            return  ResponseEntity.ok(produitDto);
        }catch(NotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @Override
    public void notifyPromotion() {
        log.info("Notification de promotion envoyé ");
        this.getAllPromotion();
    }
    public CompletableFuture<List<PromotionDto>> getAllPromotion(){
        return CompletableFuture.supplyAsync(()->this.promotionService.getAll());
    }
}
