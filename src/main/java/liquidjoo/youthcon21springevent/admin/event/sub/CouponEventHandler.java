package liquidjoo.youthcon21springevent.admin.event.sub;

import liquidjoo.youthcon21springevent.admin.application.CouponService;
import liquidjoo.youthcon21springevent.admin.event.CouponEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class CouponEventHandler implements ApplicationListener<CouponEvent> {
    private final CouponService couponService;

    public CouponEventHandler(CouponService couponService) {
        this.couponService = couponService;
    }

    @Override
    public void onApplicationEvent(CouponEvent event) {
        this.couponService.register(event.getEmail());
    }
}
