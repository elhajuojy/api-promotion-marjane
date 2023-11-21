package ma.yc.api.controller.Promotion;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PromotionManger {

    private final List<PromotionListner> promotionListner = new ArrayList<>();
    public void notifyPromotion() {
        promotionListner.forEach(PromotionListner::notifyPromotion);
    }


    public void registerListener(PromotionListner promotionListner) {
        this.promotionListner.add(promotionListner);

    }

    public void unregisterListener(PromotionListner promotionListner) {
        this.promotionListner.remove(promotionListner);
    }
}
