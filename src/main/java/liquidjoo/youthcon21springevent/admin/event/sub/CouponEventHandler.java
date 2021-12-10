package liquidjoo.youthcon21springevent.admin.event.sub;

import liquidjoo.youthcon21springevent.admin.event.CouponEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CouponEventHandler implements ApplicationListener<CouponEvent> {

    @Override
    public void onApplicationEvent(CouponEvent event) {
        log.info("쿠폰 등록 완료 : {}", event.getEmail());
    }
}
