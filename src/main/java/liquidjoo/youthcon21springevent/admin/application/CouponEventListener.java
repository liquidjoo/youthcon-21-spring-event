package liquidjoo.youthcon21springevent.admin.application;

import liquidjoo.youthcon21springevent.user.domain.UserCouponEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CouponEventListener {

    @EventListener
    public void register(UserCouponEvent userCouponEvent) {
        log.info("쿠폰 등록 완료 : {}", userCouponEvent.getEmail());
    }
}
