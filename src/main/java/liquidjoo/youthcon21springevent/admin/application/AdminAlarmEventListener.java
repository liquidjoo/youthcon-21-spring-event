package liquidjoo.youthcon21springevent.admin.application;

import liquidjoo.youthcon21springevent.user.domain.UserAdminEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AdminAlarmEventListener {

    @EventListener
    public void consume(UserAdminEvent userAdminEvent) {
        log.info("어드민 서비스 : 환영합니다 {}", userAdminEvent.getUsername());
    }
}
