package ma.yc.api.controller;

import ma.yc.api.dev.entity.ResponsableRayon;
import ma.yc.api.dev.repostiory.ResponsableRayonRepository;
import ma.yc.api.exceptions.business.AlreadyExsitsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/v1/promotion")
public class PromotionControlller {

    Logger logger = LoggerFactory.getLogger(PromotionControlller.class);
    @Autowired
    private ResponsableRayonRepository repository ;

    @GetMapping
    public ResponseEntity<List<String>> getPromotions() {
        Optional<ResponsableRayon> responsableRayonByEmail = repository.findAllByEmail("email1@gmail.com");

        ResponsableRayon responsableRayon1 = responsableRayonByEmail.orElseThrow(() ->
               new AlreadyExsitsException("Responsable Rayon not found")
        )
                ;
        System.out.println(responsableRayon1);
        return ResponseEntity.ok(List.of(
                        "Promotion 1",
                        "Promotion 2",
                        "Promotion 3",
                        "Promotion 4"
                )
        );
    }
}
