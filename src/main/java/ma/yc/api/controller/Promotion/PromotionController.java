package ma.yc.api.controller.Promotion;


import lombok.extern.log4j.Log4j2;
import ma.yc.api.dto.ProduitDto;
import ma.yc.api.dto.PromotionDto;
import ma.yc.api.dto.ResponsableDto;
import ma.yc.api.entity.ResponsableRayon;
import ma.yc.api.exceptions.business.NotFoundException;
import ma.yc.api.services.AuthentificationService;
import ma.yc.api.services.EmailService;
import ma.yc.api.services.PromotionService;
import ma.yc.api.services.ResponsablePromotionService;
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
    private EmailService emailService;
    private AuthentificationService<ResponsableDto> responsablePromotionService;

    private PromotionManger promotionManger;


    @Autowired
    public PromotionController(PromotionService promotionService, PromotionManger promotionManger, AuthentificationService<ResponsableDto> responsablePromotionService
    ,EmailService emailService
    ) {
        this.promotionService = promotionService;
        this.promotionManger = promotionManger;
        this.promotionManger.registerListener(this);
        this.responsablePromotionService = responsablePromotionService;
        this.emailService = emailService;

    }


    public List<PromotionDto> getAll() throws ExecutionException, InterruptedException {
//        throw new RuntimeException("not implemented yet");
        return this.getAllPromotion().get();

    }
    @GetMapping
    public CompletableFuture<List<PromotionDto>> getAllPromotion(){
        return CompletableFuture.supplyAsync(()->this.promotionService.getAll());
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
        // TODO: 23/11/2023 send email to all responsable promotion by using emailService
        this.getAllPromotion();
    }

}
