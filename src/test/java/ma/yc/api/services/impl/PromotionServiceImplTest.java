package ma.yc.api.services.impl;

import ma.yc.api.entity.Promotion;
import ma.yc.api.entity.ResponsableRayon;
import ma.yc.api.enums.StatusPromotion;
import ma.yc.api.repository.ProductRepository;
import ma.yc.api.repository.PromotionRepository;
import ma.yc.api.repository.ResponsableRayonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cglib.core.Local;

import java.time.LocalTime;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PromotionServiceImplTest {

    @Mock
    private  PromotionRepository promotionRepository;
    @Mock
    private  ProductRepository productRepository;
    @Mock
    private ResponsableRayonRepository responsableRayonRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void addPromotion() {
        Promotion promotion = new Promotion();
        promotion.setPrecentage(0.5);
        promotion.setDateDebut(new Date());
        promotion.setDateFin(new Date());
        promotion.setStatus(StatusPromotion.EN_ATTENTE);


        when(promotionRepository.save(promotion)).thenReturn(promotion);

        assertEquals(promotion,promotionRepository.save(promotion));
        verify(promotionRepository).save(promotion);

    }

    @Test
    void getAll() {

    }

    @Test
    void consulterListPromotionValide() {
    }

//    @Test
    void isCurrentTimeInRange() {
        final LocalTime START_TIME = LocalTime.of(8, 0); // 8 AM
        final LocalTime END_TIME = LocalTime.of(12, 0); // 12 PM
        LocalTime currentTime = LocalTime.now();

        assert currentTime.isBefore(START_TIME) || currentTime.isAfter(END_TIME);
        currentTime = LocalTime.now();
        assertTrue(currentTime.isBefore(START_TIME) || currentTime.isAfter(END_TIME));
        assertFalse(START_TIME.isAfter(END_TIME));

    }

    @Test
    void testConsulterListPromotionValide() {
    }

    @Test
    void consulterListPromotionValideParId() {
    }

    @Test
    void consulterListPromotionPourResponsableRayon() {
        ResponsableRayon responsableRayon = new ResponsableRayon();
        responsableRayon.setId(1L);
        responsableRayon.setNom("nom");
        when(responsableRayonRepository.findById(1L)).thenReturn(Optional.of(responsableRayon));
        assertEquals(responsableRayon,responsableRayonRepository.findById(1L).get());
        verify(responsableRayonRepository).findById(1L);
    }

    @Test
    void testIsCurrentTimeInRange() {
    }
}