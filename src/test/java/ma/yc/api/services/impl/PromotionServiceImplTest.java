package ma.yc.api.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.core.Local;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class PromotionServiceImplTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void addPromotion() {
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
    void convertStringToLocalTime() {
    }
}