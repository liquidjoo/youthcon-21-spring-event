package liquidjoo.youthcon21springevent.admin.event.sub;

import liquidjoo.youthcon21springevent.admin.application.CouponService;
import liquidjoo.youthcon21springevent.admin.event.CouponEvent;
import liquidjoo.youthcon21springevent.event.EventSubscriber;
import org.springframework.stereotype.Service;

@Service
public class CouponEventHandler implements EventSubscriber<CouponEvent> {
    private final CouponService couponService;

    public CouponEventHandler(CouponService couponService) {
        this.couponService = couponService;
    }

    @Override
    public void handleEvent(CouponEvent event) {
        this.couponService.register(event.getEmail());
        throw new RuntimeException();
    }
}
