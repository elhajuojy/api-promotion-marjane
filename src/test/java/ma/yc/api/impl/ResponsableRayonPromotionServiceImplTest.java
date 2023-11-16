package ma.yc.api.impl;

import ma.yc.api.dto.ResponsablePromotionDto;
import ma.yc.api.dto.ResponsablePromotionResponse;
import ma.yc.api.entity.ResponsableRayon;
import ma.yc.api.enums.StatusPromotion;
import ma.yc.api.mapper.ResponsablePromotoinMapper;
import ma.yc.api.repository.PromotionRepository;
import ma.yc.api.repository.ResponsableRayonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ResponsableRayonPromotionServiceImplTest {



    private ResponsableRayonRepository responsableRayonRepository;
    private PromotionRepository promotionRepository ;
    private ResponsablePromotoinMapper responsablePromotoinMapper ;
    @BeforeEach
    void setUp() {
    }

    @Test
    void approuverOuRefuserPromotion() {
        ResponsablePromotionResponse response  = new ResponsablePromotionResponse();
        response.setPromotionDtos(Arrays.asList(
                new ResponsablePromotionDto(1L, StatusPromotion.EN_ATTENTE),
                new ResponsablePromotionDto(2L,StatusPromotion.REFUSER),
                new ResponsablePromotionDto(3L, StatusPromotion.ACCPETER)
        ));

        assertEquals(3, response.getPromotionDtos().size());
        assertNotNull(response);
        assertTrue(!response.getPromotionDtos().isEmpty());



    }

    @Test
    void findResponsableById() {
        Long responsableId = 1L ;
        ResponsableRayon responsableRayon = new ResponsableRayon();
        responsableRayon.setId(1L);

        Optional<ResponsableRayon> responsables = Optional.of(
                responsableRayon
        );

        assertNotNull(responsables.get());
        assertEquals(1,responsables.get().getId());
        assertEquals(1,responsableId);
        assertTrue(responsables.isPresent());



    }
}